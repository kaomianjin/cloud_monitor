package com.jinkun.cloud_monitor.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jinkun.cloud_monitor.constant.TemplateEnum;
import com.jinkun.cloud_monitor.dao.*;
import com.jinkun.cloud_monitor.domain.bean.Template;
import com.jinkun.cloud_monitor.domain.bean.TemplateLable;
import com.jinkun.cloud_monitor.domain.po.*;
import com.jinkun.cloud_monitor.domain.request.TemplateDetailReq;
import com.jinkun.cloud_monitor.domain.request.TemplateQueryReq;
import com.jinkun.cloud_monitor.domain.vo.TemplateVo;
import com.jinkun.cloud_monitor.service.ITemplateService;
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
        List<TemplateVo>templateVos;
        if(ids.size()==0){
            templateVos=new ArrayList<>();
        }else{
            templateVos=templateMapper.selectListVoByParameter(ids);
        }
        return new PageInfo<>(templateVos);
    }

    @Override
    public TemplateDetail get(TemplateDetailReq req) {

        Template template=templateMapper.selectByPrimaryKey(req.getId());
        List<TemplateLable> templateLableList=templateLableMapper.selectListByTemplateId(req.getId());

        return new TemplateDetail(template,templateLableList);
    }

    @Override
    public Boolean update(TemplateUnpdateReq req) {
        Template template=new Template();
        BeanUtils.copyProperties(req,template);
        return  templateMapper.updateByPrimaryKeySelective(template)==1;
    }

    @Override
    public boolean updateTemplateLable(TemplateLableDetailReq req) {
        TemplateLable templateLable=new TemplateLable();
        BeanUtils.copyProperties(req,templateLable);
        return templateLableMapper.updateByPrimaryKeySelective(templateLable)==1;
    }

    @Override
    public boolean deleteOne(TemplateLableDeleteReq req) {

        return templateLableMapper.deleteByPrimaryKey(req.getId())==1;
    }

    @Override
    public boolean copyTemplate(TemplateCopyReq req) {
        Template template=copy(req);
        boolean tempAdd=templateMapper.insert(template)==1;
        boolean lableAdd=true;
        if (req.getTemplateLableList().size()!=0) {
            lableAdd=templateLableMapper.insertBatch(req.getTemplateLableList()) == req.getTemplateLableList().size();
        }
        return tempAdd&&lableAdd;
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
