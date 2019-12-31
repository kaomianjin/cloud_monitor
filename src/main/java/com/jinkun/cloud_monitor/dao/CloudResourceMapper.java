package com.jinkun.cloud_monitor.dao;

import com.jinkun.cloud_monitor.domain.bean.CloudResource;

public interface CloudResourceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CloudResource record);

    int insertSelective(CloudResource record);

    CloudResource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CloudResource record);

    int updateByPrimaryKey(CloudResource record);
}