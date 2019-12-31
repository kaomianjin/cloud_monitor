package com.jinkun.cloud_monitor.dao;

import com.jinkun.cloud_monitor.domain.bean.CloudDatasource;
import com.jinkun.cloud_monitor.domain.request.DataSourceQueryAllReq;

import java.util.List;

public interface CloudDatasourceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CloudDatasource record);

    int insertSelective(CloudDatasource record);

    CloudDatasource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CloudDatasource record);

    int updateByPrimaryKey(CloudDatasource record);

    List<CloudDatasource> queryByParams(DataSourceQueryAllReq req);

    int deleteBatchByIds(List<Long> ids);
}