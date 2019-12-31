package com.jinkun.cloud_monitor.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jinkun.cloud_monitor.constant.TemplateEnum;
import com.jinkun.cloud_monitor.dao.*;
import com.jinkun.cloud_monitor.domain.bean.Template;
import com.jinkun.cloud_monitor.domain.bean.TemplateLable;
import com.jinkun.cloud_monitor.domain.po.*;
import com.jinkun.cloud_monitor.domain.request.*;
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

    @Override
    public PageInfo<TemplateVo> selectList(TemplateQueryReq req) {

        PageHelper.startPage(req.getPageNum(),req.getPageSize());
        List<Long>ids=templateMapper.selectIdsByParameter(req);
        PageInfo info=new PageInfo(ids);
        List<TemplateVo>templateVos=new ArrayList<>();
        if(ids.size()!=0){
            templateVos=templateMapper.selectListVoByParameter(ids);
        }
        info.setList(templateVos);
        return info;
    }

    @Override
    public TemplateDetail get(TemplateDetailReq req) {

        Template template=templateMapper.selectByPrimaryKey(req.getId());
        List<TemplateLable> templateLableList=templateLableMapper.selectListByTemplateId(req.getId());

        return new TemplateDetail(template,templateLableList);
    }

    @Override
    public Boolean update(TemplateUnpdateReq req) {
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
        Template template=copy(req);
        boolean tempAdd=templateMapper.insert(template)==1;
        boolean lableAdd=true;
        if (req.getTemplateLableList().size()!=0) {
            lableAdd=templateLableMapper.insertBatch(req.getTemplateLableList()) == req.getTemplateLableList().size();
        }
        return tempAdd&&lableAdd;
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
        return templateMapper.deleteBatchByIds(req.getIds())==req.getIds().size();
    }

    @Override
    public boolean addTemplateLable(TemplateLableAddReq req) {
        boolean repetition=templateLableMapper.countAddRepetitionByReq(req)>0;
        AssertUtil.isTrue(repetition,"该模板下此标签已存在");
        return templateLableMapper.insert(new TemplateLable(req))==1;
    }

    private Template copy(TemplateUnpdateReq req) {
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
