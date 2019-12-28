package com.jinkun.cloud_monitor.dao;

import com.jinkun.cloud_monitor.domain.bean.MonitorManagement;

public interface MonitorManagementMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MonitorManagement record);

    int insertSelective(MonitorManagement record);

    MonitorManagement selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MonitorManagement record);

    int updateByPrimaryKey(MonitorManagement record);
}