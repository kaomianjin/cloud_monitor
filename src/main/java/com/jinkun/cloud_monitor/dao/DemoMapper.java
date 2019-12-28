package com.jinkun.cloud_monitor.dao;

import com.jinkun.cloud_monitor.domain.bean.Demo;
import com.jinkun.cloud_monitor.domain.request.DemoQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Demo record);

    int insertSelective(Demo record);

    Demo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Demo record);

    int updateByPrimaryKey(Demo record);

    List<Demo> queryByParams(DemoQuery query);
}