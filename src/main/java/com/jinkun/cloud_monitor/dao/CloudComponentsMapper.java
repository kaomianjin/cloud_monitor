package com.jinkun.cloud_monitor.dao;

import com.jinkun.cloud_monitor.domain.bean.CloudComponents;
import com.jinkun.cloud_monitor.domain.po.CloudComponentCount;
import com.jinkun.cloud_monitor.domain.po.DesignateItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CloudComponentsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CloudComponents record);

    int insertSelective(CloudComponents record);

    CloudComponents selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CloudComponents record);

    int updateByPrimaryKey(CloudComponents record);

    List<CloudComponents> selectComponentsBycloudServiceId(@Param("cloudServiceId") Long cloudServiceId);

    List<CloudComponents> selectSubsetAll();

    List<CloudComponentCount> countByServiceId(@Param("id") Long id);

    List<DesignateItem> selectAllDesignateItem();

    List<DesignateItem> selectPeakDesignateItem();
}