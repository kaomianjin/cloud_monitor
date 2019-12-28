package com.jinkun.cloud_monitor.dao;

import com.jinkun.cloud_monitor.domain.bean.Template;
import com.jinkun.cloud_monitor.domain.request.TemplateQueryReq;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TemplateMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Template record);

    int insertSelective(Template record);

    Template selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Template record);

    int updateByPrimaryKey(Template record);

    List<Template> selectListByParameter(@Param("req") TemplateQueryReq req);

}