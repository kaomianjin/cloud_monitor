package com.jinkun.cloud_monitor.dao;

import com.jinkun.cloud_monitor.domain.bean.ResourceLable;

public interface ResourceLableMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ResourceLable record);

    int insertSelective(ResourceLable record);

    ResourceLable selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ResourceLable record);

    int updateByPrimaryKey(ResourceLable record);
}