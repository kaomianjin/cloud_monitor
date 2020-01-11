package com.jinkun.cloud_monitor.service;

import com.github.pagehelper.PageInfo;
import com.jinkun.cloud_monitor.domain.bean.CloudMonitorItems;
import com.jinkun.cloud_monitor.domain.request.MonitorItemsDetailReq;
import com.jinkun.cloud_monitor.domain.request.MonitorItemsGetReq;
import com.jinkun.cloud_monitor.domain.request.MonitorItemsQueryReq;
import com.jinkun.cloud_monitor.domain.vo.MonitotrItemVo;
import com.jinkun.cloud_monitor.domain.vo.PageView;

public interface IMonitorProjectService {

    PageView<MonitotrItemVo> selectListVo(MonitorItemsQueryReq req);

    CloudMonitorItems get(MonitorItemsGetReq req);

    Boolean update(MonitorItemsDetailReq req);
}
