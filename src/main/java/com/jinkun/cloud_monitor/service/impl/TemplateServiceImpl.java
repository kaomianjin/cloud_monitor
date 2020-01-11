package com.jinkun.cloud_monitor.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jinkun.cloud_monitor.constant.TemplateEnum;
import com.jinkun.cloud_monitor.dao.*;
import com.jinkun.cloud_monitor.domain.bean.CloudMonitorItems;
import com.jinkun.cloud_monitor.domain.bean.Template;
import com.jinkun.cloud_monitor.domain.bean.TemplateLable;
import com.jinkun.cloud_monitor.domain.po.*;
import com.jinkun.cloud_monitor.domain.request.*;
import com.jinkun.cloud_monitor.domain.vo.PageView;
import com.jinkun.cloud_monitor.domain.vo.TemplateVo;
import com.jinkun.cloud_monitor.service.ITemplateService;
import com.jinkun.cloud_monitor.utils.AssertUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/***
 * @ClassName: TemplateServiceImpl
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/28 16:08
 * @version : V1.0
 */
@Service
public class TemplateServiceImpl implements ITemplateService {

    @Resource
    private TemplateMapper templateMapper;
    @Resource
    private TemplateLableMapper templateLableMapper;
    @Resource
    private CloudMonitorItemsMapper cloudMonitorItemsMapper;

    @Override
    public PageView<TemplateVo> selectList(TemplateQueryReq req) {

        PageHelper.startPage(req.getPageNum(),req.getPageSize());
        List<Long>ids=templateMapper.selectIdsByParameter(req);
        PageInfo info=new PageInfo(ids);
        List<TemplateVo>templateVos=new ArrayList<>();
        if(ids.size()!=0){
            templateVos=templateMapper.selectListVoByParameter(ids);
        }
        info.setList(templateVos);
        return new PageView<>(info);
    }

    @Override
    public TemplateDetail get(TemplateGetReq req) {

        Template template=templateMapper.selectByPrimaryKey(req.getId());
        List<TemplateLable> templateLableList=templateLableMapper.selectListByTemplateId(req.getId());

        return new TemplateDetail(template,templateLableList);
    }

    @Override
    public Boolean update(TemplateUpdateReq req) {
        boolean repetition=templateMapper.selectRepetitionByReq(req)>0;
        AssertUtil.isTrue(repetition,"模板名重复");
        Template template=new Template();
        BeanUtils.copyProperties(req,template);
        return  templateMapper.updateByPrimaryKeySelective(template)==1;
    }

    @Override
    public boolean updateTemplateLable(TemplateLableDetailReq req) {

        boolean repetition=templateLableMapper.countUpRepetitionByReq(req)>0;
        AssertUtil.isTrue(repetition,"该模板下此标签已存在");

        TemplateLable templateLable=new TemplateLable();
        BeanUtils.copyProperties(req,templateLable);
        return templateLableMapper.updateByPrimaryKeySelective(templateLable)==1;
    }

    @Override
    public boolean deleteTemplateLableOne(TemplateLableDeleteReq req) {

        return templateLableMapper.deleteByPrimaryKey(req.getId())==1;
    }

    @Override
    public boolean copyTemplate(TemplateCopyReq req) {
        boolean repetition=templateMapper.selectOneByName(req.getName())>0;
        AssertUtil.isTrue(repetition,"模板名重复");

        Template builtIn=templateMapper.selectByPrimaryKey(req.getId());
        AssertUtil.isTrue(builtIn==null,"内置模板不存在");
        AssertUtil.isTrue(builtIn.getType()!=TemplateEnum.BUILT_IN_TEMPLATE.getType(),"id参数异常");

        Template template=copy(req);
        boolean templateAdd=templateMapper.insert(template)==1;

        List<CloudMonitorItems> monitorItems=cloudMonitorItemsMapper.selectList(req.getId());
        monitorItems.forEach(temp ->{
            temp.setTemplateId(template.getId());
        });
        boolean monitorItemAdd=cloudMonitorItemsMapper.insertBatch(monitorItems)==monitorItems.size();

        boolean lableAdd=true;

        List<TemplateLable>templateLables=new ArrayList<>();
        req.getTemplateLableList().forEach(templateLable -> {

            TemplateLable lable=new TemplateLable();
            lable.setName(templateLable);
            lable.setTemplateId(template.getId());
            templateLables.add(lable);
        });

        if (templateLables.size()!=0) {
            lableAdd=templateLableMapper.insertBatch(templateLables) == req.getTemplateLableList().size();
        }
        return templateAdd&&lableAdd&&monitorItemAdd;
    }

    @Override
    public boolean deleteTemplates(TemplateDeleteReq req) {
        if (req.getIds().size()==0){
            return true;
        }
        List<Long>templateIds=templateMapper.selectTemplateIdsClassifyTemplate(req.getIds());
        AssertUtil.isTrue(templateIds.size()==req.getIds().size(),"所有删除项都存在关联的分类");
        req.getIds().removeAll(templateIds);
        if (req.getIds().size()==0){
            return true;
        }
        templateMapper.deleteBatchByIds(req.getIds());
        return true;
    }

    @Override
    public boolean addTemplateLable(TemplateLableAddReq req) {
        boolean repetition=templateLableMapper.countAddRepetitionByReq(req)>0;
        AssertUtil.isTrue(repetition,"该模板下此标签已存在");
        return templateLableMapper.insert(new TemplateLable(req))==1;
    }

    private Template copy(TemplateCopyReq req) {
        Template template=templateMapper.selectByPrimaryKey(req.getId());
        template.setId(null);
        template.setName(req.getName());
        template.setDescription(req.getDescription());
        template.setType(TemplateEnum.PERSONAL_TEMPLATE.getType());
        template.setCreateTime(new Date());
        template.setUpdateTime(new Date());
        return template;
    }
}
