package com.jinkun.cloud_monitor.service;

import com.github.pagehelper.PageInfo;
import com.jinkun.cloud_monitor.domain.request.ClassifyQueryReq;
import com.jinkun.cloud_monitor.domain.vo.ClassifyVo;

public interface IClassifyService {

    PageInfo<ClassifyVo> selectList(ClassifyQueryReq req);
}
