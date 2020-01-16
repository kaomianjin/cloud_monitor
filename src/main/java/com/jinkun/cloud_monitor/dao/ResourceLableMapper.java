package com.jinkun.cloud_monitor.dao;

import com.jinkun.cloud_monitor.domain.bean.ResourceLable;
import com.jinkun.cloud_monitor.domain.request.ResourceLableSaveReq;
import com.jinkun.cloud_monitor.domain.request.ResourceLableUpdateReq;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResourceLableMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ResourceLable record);

    int insertSelective(ResourceLable record);

    ResourceLable selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ResourceLable record);

    int updateByPrimaryKey(ResourceLable record);

    List<ResourceLable> selectLables(@Param("id") Long id);

    int deleteBatch(@Param("ids") List<Long> ids);

    int countSaveRepetitionByReq(@Param("req") ResourceLableSaveReq req);

    int countUpdateRepetitionByReq(@Param("req")ResourceLableUpdateReq req);

    List<String> selectAllLableNames();
}