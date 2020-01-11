package com.jinkun.cloud_monitor.service;

import com.github.pagehelper.PageInfo;
import com.jinkun.cloud_monitor.domain.bean.Area;
import com.jinkun.cloud_monitor.domain.vo.AreaVo;
import com.jinkun.cloud_monitor.domain.vo.CloudDataSourceDetailVo;
import com.jinkun.cloud_monitor.domain.request.*;
import com.jinkun.cloud_monitor.domain.vo.CloudDataSourceVo;
import com.jinkun.cloud_monitor.domain.vo.PageView;

import java.util.List;

public interface IDataSourceService {

    boolean save(DataSourceSaveReq req);

    boolean update(DataSourceUpdateReq req);

    boolean delete(DataSourceDeleteReq req);

    PageView<CloudDataSourceVo> selectList(DataSourceQueryReq req);

    CloudDataSourceDetailVo selectOne(DataSourceGetReq req);

    Boolean verificationAccount(DataSourceVerificationReq req);

    List<Area> queryAreaVo(DataSourceAreaQueryReq req);
}
