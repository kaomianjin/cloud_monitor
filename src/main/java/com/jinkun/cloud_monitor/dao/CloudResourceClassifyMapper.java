package com.jinkun.cloud_monitor.dao;

import com.jinkun.cloud_monitor.domain.bean.CloudResourceClassify;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CloudResourceClassifyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CloudResourceClassify record);

    int insertSelective(CloudResourceClassify record);

    CloudResourceClassify selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CloudResourceClassify record);

    int updateByPrimaryKey(CloudResourceClassify record);

    int deleteByResourceIds(@Param("ids") List<Long> ids);
}