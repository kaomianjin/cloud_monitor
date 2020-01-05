package com.jinkun.cloud_monitor.service;

import com.github.pagehelper.PageInfo;
import com.jinkun.cloud_monitor.domain.vo.CloudDataSourceDetailVo;
import com.jinkun.cloud_monitor.domain.request.*;
import com.jinkun.cloud_monitor.domain.vo.CloudDataSourceVo;

public interface IDataSourceService {

    boolean save(DataSourceSaveReq req);

    boolean update(DataSourceUpdateReq req);

    boolean delete(DataSourceDeleteReq req);

    PageInfo<CloudDataSourceVo> selectList(DataSourceQueryReq req);

    CloudDataSourceDetailVo selectOne(DataSourceGetReq req);

}
