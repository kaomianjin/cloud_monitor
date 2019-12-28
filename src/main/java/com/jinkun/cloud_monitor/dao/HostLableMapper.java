package com.jinkun.cloud_monitor.dao;

import com.jinkun.cloud_monitor.domain.bean.HostLable;

public interface HostLableMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HostLable record);

    int insertSelective(HostLable record);

    HostLable selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HostLable record);

    int updateByPrimaryKey(HostLable record);
}