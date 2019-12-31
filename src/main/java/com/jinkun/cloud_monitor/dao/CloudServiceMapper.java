package com.jinkun.cloud_monitor.dao;

import com.jinkun.cloud_monitor.domain.bean.CloudService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CloudServiceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CloudService record);

    int insertSelective(CloudService record);

    CloudService selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CloudService record);

    int updateByPrimaryKey(CloudService record);

    List<CloudService> selectByTypeId(@Param("cloudTypeId") Long cloudTypeId);
}