package com.jinkun.cloud_monitor.dao;

import com.jinkun.cloud_monitor.domain.bean.Graph;

public interface GraphMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Graph record);

    int insertSelective(Graph record);

    Graph selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Graph record);

    int updateByPrimaryKey(Graph record);
}