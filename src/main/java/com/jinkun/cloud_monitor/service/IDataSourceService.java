package com.jinkun.cloud_monitor.service;

import com.github.pagehelper.PageInfo;
import com.jinkun.cloud_monitor.domain.po.CloudDataSourceDetailVo;
import com.jinkun.cloud_monitor.domain.request.*;
import com.jinkun.cloud_monitor.domain.vo.CloudDataSourceVo;

public interface IDataSourceService {

    boolean save(DataSourceReq req);

    boolean update(DataSourceUpdateReq req);

    boolean delete(DataSourceDeleteReq req);

    PageInfo<CloudDataSourceVo> selectList(DataSourceQueryAllReq req);

    CloudDataSourceDetailVo selectOne(DataSourceQueryOneReq req);

}
