package com.jinkun.cloud_monitor.dao;

import com.jinkun.cloud_monitor.domain.bean.GraphMonitorItems;

public interface GraphMonitorItemsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GraphMonitorItems record);

    int insertSelective(GraphMonitorItems record);

    GraphMonitorItems selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GraphMonitorItems record);

    int updateByPrimaryKey(GraphMonitorItems record);
}