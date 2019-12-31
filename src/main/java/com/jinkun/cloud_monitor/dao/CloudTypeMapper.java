package com.jinkun.cloud_monitor.dao;

import com.jinkun.cloud_monitor.domain.bean.CloudType;

import java.util.List;

public interface CloudTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CloudType record);

    int insertSelective(CloudType record);

    CloudType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CloudType record);

    int updateByPrimaryKey(CloudType record);

    List<CloudType> selectAll();
}