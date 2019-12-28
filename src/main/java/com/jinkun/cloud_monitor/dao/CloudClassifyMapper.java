package com.jinkun.cloud_monitor.dao;

import com.jinkun.cloud_monitor.domain.bean.CloudClassify;

public interface CloudClassifyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CloudClassify record);

    int insertSelective(CloudClassify record);

    CloudClassify selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CloudClassify record);

    int updateByPrimaryKey(CloudClassify record);
}