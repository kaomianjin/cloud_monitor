package com.jinkun.cloud_monitor.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jinkun.cloud_monitor.dao.*;
import com.jinkun.cloud_monitor.domain.bean.*;
import com.jinkun.cloud_monitor.domain.po.ClassifyDetail;
import com.jinkun.cloud_monitor.domain.request.*;
import com.jinkun.cloud_monitor.domain.vo.ClassifyVo;
import com.jinkun.cloud_monitor.service.IClassifyService;
import com.jinkun.cloud_monitor.utils.AssertUtil;
import org.springframework.stereotype.Service;
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

    @Override
    public PageInfo<ClassifyVo> selectList(ClassifyQueryReq req) {

        PageHelper.startPage(req.getPageNum(),req.getPageSize());
        List<Long>ids=cloudClassifyMapper.selectIds(req);
        PageInfo info=new PageInfo<>(ids);
        List<ClassifyVo>classifyVos=new ArrayList<>();
        if(ids.size()!=0){
            classifyVos=cloudClassifyMapper.selectListVoByParameter(ids);
        }
        info.setList(classifyVos);
        return info;
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
                .template(template);

        return builder.build();
    }

    @Override
    @Transactional
    public boolean save(ClassifyDetailReq req) {

        boolean repetition=cloudClassifyMapper.countUpRepetitionByReq(req)>0;

        AssertUtil.isTrue(repetition,"分类名称重复");

        CloudClassify cloudClassify=new CloudClassify(req);

        boolean insetClassity=cloudClassifyMapper.insert(cloudClassify)==1;

        boolean insetClassityTemplate=cloudClassifyMapper.inserClassifyTemplate(req.getTemplateId(),cloudClassify.getId())==1;

        return insetClassity&&insetClassityTemplate;
    }

    @Override
    @Transactional
    public boolean update(ClassifyDetailReq req) {

        boolean repetition=cloudClassifyMapper.countUpRepetitionByReq(req)>0;

        AssertUtil.isTrue(repetition,"分类名称重复");

        CloudClassify cloudClassify=new CloudClassify(req);

        CloudClassifyTemplate cloudResourceClassify=new CloudClassifyTemplate(req.getTemplateId(),req.getId());

        boolean updateClassity=cloudClassifyMapper.updateByPrimaryKeySelective(cloudClassify)==1;

        cloudClassifyTemplateMapper.deleteByClassify(req.getId());

        boolean updateClassityTemplate=cloudClassifyTemplateMapper.insertSelective(cloudResourceClassify)==1;

        return updateClassity&&updateClassityTemplate;
    }

    @Override
    @Transactional
    public boolean deleteBatch(ClassifyDeleteReq req) {

        if (req.getIds().size()==0){
            return true;
        }
        List<Long>classifyIds=cloudClassifyMapper.selectClassifyResourceByClassifyIds(req.getIds());
        AssertUtil.isTrue(classifyIds.size()==req.getIds().size(),"所有删除项都存在关联的资源");
        req.getIds().removeAll(classifyIds);
        return cloudClassifyMapper.deleteBatchByIds(req.getIds())==req.getIds().size();
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
