package com.jinkun.cloud_monitor.dao;

import com.jinkun.cloud_monitor.domain.bean.Trigger;
import com.jinkun.cloud_monitor.domain.request.TriggerQueryReq;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TriggerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Trigger record);

    int insertSelective(Trigger record);

    Trigger selectByPrimaryKey(@Param("id") Long id);

    int updateByPrimaryKeySelective(Trigger record);

    int updateByPrimaryKey(Trigger record);

    List<Trigger> selectList(@Param("req") TriggerQueryReq req);

    int deleteBatch(@Param("ids") List<Long> ids);

    List<Trigger> selectListByTemplateId(@Param("id") Long id);
}