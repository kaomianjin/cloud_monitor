package com.jinkun.cloud_monitor.dao;

import com.jinkun.cloud_monitor.domain.bean.HostGroup;

public interface HostGroupMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HostGroup record);

    int insertSelective(HostGroup record);

    HostGroup selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HostGroup record);

    int updateByPrimaryKey(HostGroup record);
}