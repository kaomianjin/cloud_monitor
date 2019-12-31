package com.jinkun.cloud_monitor.service;

import com.github.pagehelper.PageInfo;
import com.jinkun.cloud_monitor.domain.bean.CloudComponents;
import com.jinkun.cloud_monitor.domain.bean.CloudService;
import com.jinkun.cloud_monitor.domain.bean.CloudType;
import com.jinkun.cloud_monitor.domain.po.ClassifyDetail;
import com.jinkun.cloud_monitor.domain.request.*;
import com.jinkun.cloud_monitor.domain.vo.ClassifyVo;

import java.util.List;

public interface IClassifyService {

    PageInfo<ClassifyVo> selectList(ClassifyQueryReq req);

    ClassifyDetail getDetail(ClassifyGetReq req);

    boolean save(ClassifyDetailReq req);

    boolean update(ClassifyDetailReq req);

    boolean deleteBatch(ClassifyDeleteReq req);

    List<CloudType> selectCloudType();

    List<CloudService> selectCloudService(CloudServiceQueryReq req);

    List<CloudComponents> selectComponents(ComponentsQueryReq req);
}
