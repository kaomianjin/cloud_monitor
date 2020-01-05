package com.jinkun.cloud_monitor.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jinkun.cloud_monitor.constant.CloudConstant;
import com.jinkun.cloud_monitor.constant.ResponseEnum;
import com.jinkun.cloud_monitor.dao.CloudDatasourceMapper;
import com.jinkun.cloud_monitor.dao.CloudServiceMapper;
import com.jinkun.cloud_monitor.dao.CloudTypeMapper;
import com.jinkun.cloud_monitor.domain.bean.CloudDatasource;
import com.jinkun.cloud_monitor.domain.po.AliyunVerify;
import com.jinkun.cloud_monitor.domain.vo.CloudDataSourceDetailVo;
import com.jinkun.cloud_monitor.domain.po.HuaweiVerify;
import com.jinkun.cloud_monitor.domain.request.*;
import com.jinkun.cloud_monitor.domain.vo.CloudDataSourceVo;
import com.jinkun.cloud_monitor.service.IDataSourceService;
import com.jinkun.cloud_monitor.utils.AssertUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    private CloudServiceMapper cloudServiceMapper;

    @Resource
    private CloudDatasourceMapper cloudDatasourceMapper;

    @Resource
    private CloudTypeMapper cloudTypeMapper;


    @Override
    public boolean save(DataSourceSaveReq req) {

        checkDataSourceCreate(req);

        CloudDatasource cloudDatasource=new CloudDatasource(req);

        int count=cloudDatasourceMapper.insert(cloudDatasource);

        AssertUtil.isTrue(count!=0,"添加失败");

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

        List<CloudDataSourceVo> cloudDataSourceVos=new ArrayList<>();
        entities.forEach(temp ->{

        });
        return cloudDataSourceVos;
    }
}
