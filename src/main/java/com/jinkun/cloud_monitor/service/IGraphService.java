package com.jinkun.cloud_monitor.service;

import com.github.pagehelper.PageInfo;
import com.jinkun.cloud_monitor.domain.po.GraphDetail;
import com.jinkun.cloud_monitor.domain.request.*;
import com.jinkun.cloud_monitor.domain.vo.GraphVo;
import com.jinkun.cloud_monitor.domain.vo.PageView;
import com.jinkun.cloud_monitor.domain.vo.TemplateClassifyVo;

import java.util.List;

public interface IGraphService {

    PageView<GraphVo> selectList(GraphQueryReq req);

    GraphDetail getDetail(GraphGetReq req);

    boolean saveGraph(GraphAddReq req);

    boolean updateGraph(GraphUpdateReq req);

    boolean deleteBatchGraph(GraphDeleteReq req);

}
