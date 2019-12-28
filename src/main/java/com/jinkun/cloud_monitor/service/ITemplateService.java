package com.jinkun.cloud_monitor.service;

import com.jinkun.cloud_monitor.domain.request.TemplateQueryReq;
import com.jinkun.cloud_monitor.domain.vo.TemplateVo;

import java.util.List;

public interface ITemplateService {

    List<TemplateVo> selectList(TemplateQueryReq req);
}
