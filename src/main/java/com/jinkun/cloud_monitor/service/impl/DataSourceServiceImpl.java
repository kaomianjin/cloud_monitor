package com.jinkun.cloud_monitor.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jinkun.cloud_monitor.client.PrometheusClient;
import com.jinkun.cloud_monitor.constant.CloudConstant;
import com.jinkun.cloud_monitor.constant.PrometheusConstant;
import com.jinkun.cloud_monitor.constant.ResponseEnum;
import com.jinkun.cloud_monitor.dao.*;
import com.jinkun.cloud_monitor.domain.bean.*;
import com.jinkun.cloud_monitor.domain.po.AliyunVerify;
import com.jinkun.cloud_monitor.domain.vo.AreaVo;
import com.jinkun.cloud_monitor.domain.vo.CloudDataSourceDetailVo;
import com.jinkun.cloud_monitor.domain.po.HuaweiVerify;
import com.jinkun.cloud_monitor.domain.request.*;
import com.jinkun.cloud_monitor.domain.vo.CloudDataSourceVo;
import com.jinkun.cloud_monitor.service.ICloudTypeManagementService;
import com.jinkun.cloud_monitor.service.IDataSourceService;
import com.jinkun.cloud_monitor.utils.AssertUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/***
 * @ClassName: DataSourceServiceImpl
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/27 14:16
 * @version : V1.0
 */
@Service
public class DataSourceServiceImpl implements IDataSourceService {

    @Resource
    private AreaMapper areaMapper;

    @Resource
    private CloudServiceMapper cloudServiceMapper;

    @Resource
    private VerificationAccountMapper verificationAccountMapper;

    @Resource
    private CloudDatasourceMapper cloudDatasourceMapper;

    @Resource
    private CloudTypeMapper cloudTypeMapper;

    @Resource
    private ICloudTypeManagementService cloudTypeManagementService;

    @Resource
    private PrometheusClient prometheusClient;

    @Override
    public boolean save(DataSourceSaveReq req) {

        checkDataSourceCreate(req);

        CloudDatasource cloudDatasource=new CloudDatasource(req);

        int count=cloudDatasourceMapper.countByService(req.getCloudService().getId());

        AssertUtil.isTrue(count>0,"目前只支持一个"+req.getCloudService().getName()+"账号");

        AssertUtil.isTrue(cloudDatasourceMapper.insert(cloudDatasource)!=0,"添加失败");

        cloudTypeManagementService.addTypeManagement(cloudDatasource.getId());
        return true;
    }

    private void checkDataSourceCreate(DataSourceSaveReq req) {
        if (CloudConstant.CLOUD_SERVICE_ALI.equals(req.getCloudService().getName())||CloudConstant.CLOUD_SERVICE_HUAWEI.equals(req.getCloudService().getName())){
            return;
        }
        AssertUtil.isTrue(true, ResponseEnum.PARAMETER_ERROR.getMsg());
    }

    @Override
    public boolean update(DataSourceUpdateReq req) {

        checkDataSourceUpdate(req);

        CloudDatasource cloudDatasource=new CloudDatasource(req);

        int count=cloudDatasourceMapper.updateByPrimaryKey(cloudDatasource);

        AssertUtil.isTrue(count!=0,"更新失败");

        return true;
    }

    private void checkDataSourceUpdate(DataSourceUpdateReq req) {
        if (CloudConstant.CLOUD_SERVICE_ALI.equals(req.getCloudService().getName())||CloudConstant.CLOUD_SERVICE_HUAWEI.equals(req.getCloudService().getName())){
            return;
        }
        AssertUtil.isTrue(true, ResponseEnum.PARAMETER_ERROR.getMsg());
    }

    @Override
    public boolean delete(DataSourceDeleteReq req) {

        if (req.getIds()!=null&&req.getIds().size()!=0) {
            cloudTypeManagementService.deleteByDataSourceIds(req.getIds());
            return cloudDatasourceMapper.deleteBatchByIds(req.getIds())==req.getIds().size();
        }
        return true;
    }

    @Override
    public PageInfo<CloudDataSourceVo> selectList(DataSourceQueryReq req) {
        PageHelper.startPage(req.getPageNum(),req.getPageSize());
        List<CloudDatasource> entities=cloudDatasourceMapper.queryByParams(req);
        PageInfo info=new PageInfo(entities);
        List<CloudDataSourceVo> cloudDataSourceVos=cloudDataSourceVosList(entities);
        info.setList(cloudDataSourceVos);
        return info;
    }

    @Override
    public CloudDataSourceDetailVo selectOne(DataSourceGetReq req) {
        CloudDatasource cloudDatasource =cloudDatasourceMapper.selectByPrimaryKey(req.getId());
        return getCloudDataSourceDetailVo(cloudDatasource);
    }

    @Override
    public Boolean verificationAccount(DataSourceVerificationReq req) {

        VerificationAccount verificationAccount=verificationAccountMapper.selectByKey(req.getKey());

        if (verificationAccount!=null){
            String times=verificationAccount.getTimes();
            List<Long> timeList=JSON.parseObject(times,ArrayList.class);
            if (timeList.size()>=5) {
                if ((System.currentTimeMillis() - timeList.get(0)) < PrometheusConstant.TWOHOUR) {
                    throw new RuntimeException("2小时内不能验证超过5次");
                }
            }
        }

        Boolean verification;
        if (CloudConstant.VERIFICATION_PROMETHEUS.equals(req.getType())){
            verification=prometheusClient.verificationAccount(req);
        }else if (CloudConstant.VERIFICATION_CMDB.equals(req.getType())){
            verification=prometheusClient.verificationAccount(req);
        }else {
            throw new RuntimeException("参数错误");
        }

        if (verificationAccount==null){
            List<Long>times=new ArrayList<>();
            times.add(System.currentTimeMillis());
            verificationAccount =new  VerificationAccount();
            verificationAccount.setAccountId(req.getKey());
            verificationAccount.setTimes(JSON.toJSONString(times));
            verificationAccount.setLastTime(System.currentTimeMillis());
            verificationAccountMapper.insert(verificationAccount);
        }else{
            String times=verificationAccount.getTimes();
            List<Long> timeList=JSON.parseObject(times,ArrayList.class);
            if (timeList.size()>=5){
                List<Long> newTimes=new ArrayList<>();
                for (int i=0;i<timeList.size();i++){
                    if (i==0){
                        continue;
                    }
                    newTimes.add(timeList.get(i));
                }
                verificationAccount.setTimes(JSON.toJSONString(newTimes));
            }else{
                timeList.add(System.currentTimeMillis());
                verificationAccount.setTimes(JSON.toJSONString(timeList));
            }
            verificationAccountMapper.updateByPrimaryKeySelective(verificationAccount);
        }

        return verification;

    }

    @Override
    public List<Area> queryAreaVo(DataSourceAreaQueryReq req) {
        return areaMapper.selectByServiceId(req.getCloudServiceId());
    }


    private  CloudDataSourceDetailVo getCloudDataSourceDetailVo(CloudDatasource cloudDatasource){

        CloudDataSourceDetailVo cloudDataSourceDetailVo=new CloudDataSourceDetailVo();

        BeanUtils.copyProperties(cloudDatasource,cloudDataSourceDetailVo);

        cloudDataSourceDetailVo.setCloudType(cloudTypeMapper.selectByPrimaryKey(cloudDatasource.getCloudTypeId()));

        cloudDataSourceDetailVo.setCloudService(cloudServiceMapper.selectByPrimaryKey(cloudDatasource.getCloudServiceId()));
        if (CloudConstant.CLOUD_SERVICE_ALI.equals(cloudDataSourceDetailVo.getCloudService().getName())){
            cloudDataSourceDetailVo.setAliyunVerify(JSON.parseObject(cloudDatasource.getVerificationInformation(), AliyunVerify.class));
        }else if (CloudConstant.CLOUD_SERVICE_HUAWEI.equals(cloudDataSourceDetailVo.getCloudService().getName())){
            cloudDataSourceDetailVo.setHuaweiVerify(JSON.parseObject(cloudDatasource.getVerificationInformation(), HuaweiVerify.class));
        }

        return cloudDataSourceDetailVo;
    }

    private List<CloudDataSourceVo> cloudDataSourceVosList(List<CloudDatasource> entities) {
        List<CloudService> cloudServices=cloudServiceMapper.selectAll();
        List<CloudType> cloudTypes=cloudTypeMapper.selectAll();
        List<CloudDataSourceVo> cloudDataSourceVos=new ArrayList<>();

        entities.forEach(temp ->{
            CloudDataSourceVo cloudDataSourceVo=new CloudDataSourceVo();
            cloudDataSourceVo.setId(temp.getId());
            cloudDataSourceVo.setName(temp.getName());
            cloudDataSourceVo.setStatus(temp.getStatus());
            cloudDataSourceVo.setAccountStatus(true);
            cloudDataSourceVo.setSync(true);
            cloudDataSourceVo.setCloudType(getCloudType(cloudTypes,temp.getCloudTypeId()));
            cloudDataSourceVo.setCloudService(getCloudService(cloudServices,temp.getCloudServiceId()));
            cloudDataSourceVos.add(cloudDataSourceVo);
        });

        return cloudDataSourceVos;
    }

    private CloudService getCloudService(List<CloudService> cloudServices, Long cloudServiceId) {
        for (CloudService cloudService:cloudServices){
            if (cloudService.getId().equals(cloudServiceId)){
                return cloudService;
            }
        }
        return null;
    }

    private CloudType getCloudType(List<CloudType> cloudTypes, Long cloudTypeId) {

        for (CloudType cloudType:cloudTypes){
            if (cloudType.getId().equals(cloudTypeId)){
                return cloudType;
            }
        }

        return null;
    }



}
