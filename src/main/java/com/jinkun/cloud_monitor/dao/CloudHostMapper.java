package com.jinkun.cloud_monitor.dao;

import com.jinkun.cloud_monitor.domain.bean.CloudHost;

public interface CloudHostMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CloudHost record);

    int insertSelective(CloudHost record);

    CloudHost selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CloudHost record);

    int updateByPrimaryKey(CloudHost record);
}