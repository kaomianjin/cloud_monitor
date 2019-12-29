package com.jinkun.cloud_monitor.service;

import com.github.pagehelper.PageInfo;
import com.jinkun.cloud_monitor.domain.po.*;
import com.jinkun.cloud_monitor.domain.request.TemplateDetailReq;
import com.jinkun.cloud_monitor.domain.request.TemplateQueryReq;
import com.jinkun.cloud_monitor.domain.vo.TemplateVo;

public interface ITemplateService {

    PageInfo<TemplateVo> selectList(TemplateQueryReq req);

    TemplateDetail get(TemplateDetailReq req);

    Boolean update(TemplateUnpdateReq req);

    boolean updateTemplateLable(TemplateLableDetailReq req);

    boolean deleteOne(TemplateLableDeleteReq req);

    boolean copyTemplate(TemplateCopyReq req);
}
