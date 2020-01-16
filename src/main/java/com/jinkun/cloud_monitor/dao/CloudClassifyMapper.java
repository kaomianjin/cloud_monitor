package com.jinkun.cloud_monitor.dao;

import com.jinkun.cloud_monitor.domain.bean.CloudClassify;
import com.jinkun.cloud_monitor.domain.bean.Template;
import com.jinkun.cloud_monitor.domain.request.ClassifyDetailReq;
import com.jinkun.cloud_monitor.domain.request.ClassifyQueryReq;
import com.jinkun.cloud_monitor.domain.vo.ClassifyVo;
import com.jinkun.cloud_monitor.domain.vo.TemplateClassifyVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CloudClassifyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CloudClassify record);

    int insertSelective(CloudClassify record);

    CloudClassify selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CloudClassify record);

    int updateByPrimaryKey(CloudClassify record);

    List<ClassifyVo> selectListVoByParameter(@Param("ids") List<Long> ids);

    List<Long> selectIds(@Param("req") ClassifyQueryReq req);

    Template selectTemplateByPrimaryKey(@Param("id")Long id);

    int countUpRepetitionByReq(@Param("req")ClassifyDetailReq req);

    int inserClassifyTemplate(@Param("templateId")Long templateId,@Param("classifyId") Long id);

    List<Long> selectClassifyResourceByClassifyIds(@Param("ids")List<Long> ids);

    int deleteBatchByIds(@Param("ids")List<Long> ids);

    List<TemplateClassifyVo> selectVoByTemplateId(@Param("templateId") Long templateId);
}