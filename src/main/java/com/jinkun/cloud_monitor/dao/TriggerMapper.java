package com.jinkun.cloud_monitor.dao;

import com.jinkun.cloud_monitor.domain.bean.Trigger;

public interface TriggerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Trigger record);

    int insertSelective(Trigger record);

    Trigger selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Trigger record);

    int updateByPrimaryKey(Trigger record);
}