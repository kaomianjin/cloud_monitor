package com.jinkun.cloud_monitor.dao;

import com.jinkun.cloud_monitor.domain.bean.TemplateLable;
import com.jinkun.cloud_monitor.domain.request.TemplateLableAddReq;
import com.jinkun.cloud_monitor.domain.request.TemplateLableDetailReq;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TemplateLableMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TemplateLable record);

    int insertSelective(TemplateLable record);

    TemplateLable selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TemplateLable record);

    int updateByPrimaryKey(TemplateLable record);

    List<TemplateLable> selectListByTemplateId(@Param("templateId") Long templateId);

    int insertBatch(@Param("templateLableList") List<TemplateLable> templateLableList);

    int countAddRepetitionByReq(@Param("req") TemplateLableAddReq req);

    int countUpRepetitionByReq(@Param("req")TemplateLableDetailReq req);
}