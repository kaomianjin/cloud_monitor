package com.jinkun.cloud_monitor.dao;

import com.jinkun.cloud_monitor.domain.bean.CloudMonitorItems;

public interface CloudMonitorItemsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CloudMonitorItems record);

    int insertSelective(CloudMonitorItems record);

    CloudMonitorItems selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CloudMonitorItems record);

    int updateByPrimaryKey(CloudMonitorItems record);
}