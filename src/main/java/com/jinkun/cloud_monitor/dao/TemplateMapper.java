package com.jinkun.cloud_monitor.dao;

import com.jinkun.cloud_monitor.domain.bean.Template;
import com.jinkun.cloud_monitor.domain.request.TemplateQueryReq;
import com.jinkun.cloud_monitor.domain.vo.TemplateVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TemplateMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Template record);

    int insertSelective(Template record);

    Template selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Template record);

    int updateByPrimaryKey(Template record);

    List<Long> selectIdsByParameter(@Param("req") TemplateQueryReq req);

    List<TemplateVo> selectListVoByParameter(@Param("ids")List<Long> ids);
}