package com.jinkun.cloud_monitor.dao;

import com.jinkun.cloud_monitor.domain.bean.TemplateMonitorItems;

public interface TemplateMonitorItemsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TemplateMonitorItems record);

    int insertSelective(TemplateMonitorItems record);

    TemplateMonitorItems selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TemplateMonitorItems record);

    int updateByPrimaryKey(TemplateMonitorItems record);
}