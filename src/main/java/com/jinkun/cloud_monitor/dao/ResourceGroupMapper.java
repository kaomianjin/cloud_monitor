package com.jinkun.cloud_monitor.dao;

import com.jinkun.cloud_monitor.domain.bean.ResourceGroup;

public interface ResourceGroupMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ResourceGroup record);

    int insertSelective(ResourceGroup record);

    ResourceGroup selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ResourceGroup record);

    int updateByPrimaryKey(ResourceGroup record);
}