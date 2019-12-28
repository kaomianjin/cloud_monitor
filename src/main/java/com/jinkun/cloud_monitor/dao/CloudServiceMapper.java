package com.jinkun.cloud_monitor.dao;

import com.jinkun.cloud_monitor.domain.bean.CloudService;

public interface CloudServiceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CloudService record);

    int insertSelective(CloudService record);

    CloudService selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CloudService record);

    int updateByPrimaryKey(CloudService record);
}