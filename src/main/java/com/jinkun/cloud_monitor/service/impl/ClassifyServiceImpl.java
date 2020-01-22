package com.jinkun.cloud_monitor.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jinkun.cloud_monitor.client.PrometheusClient;
import com.jinkun.cloud_monitor.client.pojo.Prometheus.ResourceTigger;
import com.jinkun.cloud_monitor.constant.Prometheus.PrometheusConstant;
import com.jinkun.cloud_monitor.dao.*;
import com.jinkun.cloud_monitor.domain.bean.*;
import com.jinkun.cloud_monitor.domain.po.ClassifyDetail;
import com.jinkun.cloud_monitor.domain.request.*;
import com.jinkun.cloud_monitor.domain.vo.ClassifyVo;
import com.jinkun.cloud_monitor.domain.vo.PageView;
import com.jinkun.cloud_monitor.service.IClassifyService;
import com.jinkun.cloud_monitor.utils.lang.AssertUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/***
 * @ClassName: ClassifyServiceImpl
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/30 17:19
 * @version : V1.0
 */
@Service
public class ClassifyServiceImpl implements IClassifyService {

    @Resource
    private CloudClassifyMapper cloudClassifyMapper;
    @Resource
    private CloudServiceMapper cloudServiceMapper;
    @Resource
    private CloudComponentsMapper cloudComponentsMapper;
    @Resource
    private CloudClassifyTemplateMapper cloudClassifyTemplateMapper;
    @Resource
    private CloudTypeMapper cloudTypeMapper;
    @Resource
    private PrometheusClient prometheusClient;
    @Resource
    private TriggerMapper triggerMapper;
    @Resource
    private CloudResourceMapper cloudResourceMapper;

    @Override
    public PageView<ClassifyVo> selectList(ClassifyQueryReq req) {

        PageHelper.startPage(req.getPageNum(),req.getPageSize());
        List<Long>ids=cloudClassifyMapper.selectIds(req);
        PageInfo pageInfo=new PageInfo<>(ids);
        List<ClassifyVo>classifyVos=new ArrayList<>();
        if(ids.size()!=0){
            classifyVos=cloudClassifyMapper.selectListVoByParameter(ids);
        }
        pageInfo.setList(classifyVos);

        return new PageView<ClassifyVo>(pageInfo);
    }

    @Override
    public ClassifyDetail getDetail(ClassifyGetReq req) {

        CloudClassify classify =cloudClassifyMapper.selectByPrimaryKey(req.getId());

        Template template=cloudClassifyMapper.selectTemplateByPrimaryKey(classify.getId());

        CloudService cloudService=cloudServiceMapper.selectByPrimaryKey(classify.getCloudServiceId());

        CloudComponents cloudComponents=cloudComponentsMapper.selectByPrimaryKey(classify.getCloudComponentsId());

        ClassifyDetail.ClassifyDetailBuilder builder=ClassifyDetail.builder().id(classify.getId())
                .name(classify.getName())
                .cloudService(cloudService)
                .cloudComponents(cloudComponents)
                .template(template)
                .status(classify.isStatus())
                .description(classify.getDescription());

        return builder.build();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public boolean save(ClassifyDetailReq req) {

        boolean repetition=cloudClassifyMapper.countUpRepetitionByReq(req)>0;

        AssertUtil.isTrue(repetition,"分类名称重复");

        CloudClassify cloudClassify=new CloudClassify(req);

        cloudClassifyMapper.insert(cloudClassify);

        List<CloudClassifyTemplate> cloudClassifyTemplates=new ArrayList<>();
        req.getTemplateIds().forEach(templateId ->{
            CloudClassifyTemplate cloudClassifyTemplate=new CloudClassifyTemplate();
            cloudClassifyTemplate.setTemplateId(templateId);
            cloudClassifyTemplate.setClassifyId(cloudClassify.getId());
            cloudClassifyTemplates.add(cloudClassifyTemplate);
        });
        if (cloudClassifyTemplates.size()>0){
            cloudClassifyTemplateMapper.insertBatch(cloudClassifyTemplates);
        }
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public boolean update(ClassifyDetailReq req) {

        boolean repetition=cloudClassifyMapper.countUpRepetitionByReq(req)>0;

        AssertUtil.isTrue(repetition,"分类名称重复");

        CloudClassify cloudClassify=new CloudClassify(req);

        cloudClassifyMapper.updateByPrimaryKeySelective(cloudClassify);

        cloudClassifyTemplateMapper.deleteByClassify(req.getId());

        List<Long>templateIds=req.getTemplateIds();

        List<CloudClassifyTemplate> cloudClassifyTemplates=new ArrayList<>();
        templateIds.forEach(templateId ->{

            CloudClassifyTemplate cloudClassifyTemplate=new CloudClassifyTemplate(templateId,req.getId());

            cloudClassifyTemplates.add(cloudClassifyTemplate);
        });

        cloudClassifyTemplateMapper.insertBatch(cloudClassifyTemplates);

        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public boolean deleteBatch(ClassifyDeleteReq req) {

        if (req.getIds().size()==0){
            return true;
        }
        List<Long>classifyIds=cloudClassifyMapper.selectClassifyResourceByClassifyIds(req.getIds());
        AssertUtil.isTrue(classifyIds.size()==req.getIds().size(),"所有删除项都存在关联的资源");
        req.getIds().removeAll(classifyIds);
        cloudClassifyMapper.deleteBatchByIds(req.getIds());
        return true;
    }

    @Override
    public List<CloudType> selectCloudType() {

        return cloudTypeMapper.selectAll();
    }

    @Override
    public List<CloudService> selectCloudService(CloudServiceQueryReq req) {

        return cloudServiceMapper.selectByTypeId(req.getId());
    }

    @Override
    public List<CloudComponents> selectComponents(ComponentsQueryReq req) {

        return cloudComponentsMapper.selectComponentsBycloudServiceId(req.getId());
    }

}
