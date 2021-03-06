package com.jinkun.cloud_monitor.service;

import com.github.pagehelper.PageInfo;
import com.jinkun.cloud_monitor.domain.po.*;
import com.jinkun.cloud_monitor.domain.request.*;
import com.jinkun.cloud_monitor.domain.vo.PageView;
import com.jinkun.cloud_monitor.domain.vo.TemplateClassifyVo;
import com.jinkun.cloud_monitor.domain.vo.TemplateVo;

import java.util.List;

public interface ITemplateService {

    PageView<TemplateVo> selectList(TemplateQueryReq req);

    TemplateDetail get(TemplateGetReq req);

    Boolean update(TemplateUpdateReq req);

    boolean updateTemplateLable(TemplateLableDetailReq req);

    boolean deleteTemplateLableOne(TemplateLableDeleteReq req);

    boolean copyTemplate(TemplateCopyReq req);

    boolean deleteTemplates(TemplateDeleteReq req);

    boolean addTemplateLable(TemplateLableAddReq req);

    List<TemplateClassifyVo> selectBatchClassify(TemplateClassifyQuery req);
}
