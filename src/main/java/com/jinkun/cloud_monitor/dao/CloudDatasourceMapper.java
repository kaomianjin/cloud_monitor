package com.jinkun.cloud_monitor.dao;

import com.jinkun.cloud_monitor.domain.bean.CloudDatasource;
import com.jinkun.cloud_monitor.domain.request.DataSourceQueryReq;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CloudDatasourceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CloudDatasource record);

    int insertSelective(CloudDatasource record);

    CloudDatasource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CloudDatasource record);

    int updateByPrimaryKey(CloudDatasource record);

    List<CloudDatasource> queryByParams(@Param("req") DataSourceQueryReq req);

    int deleteBatchByIds(@Param("ids")List<Long> ids);

    List<CloudDatasource> selectAll();

    int countByService(@Param("id") Long id);
}