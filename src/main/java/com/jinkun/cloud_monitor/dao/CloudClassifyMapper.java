package com.jinkun.cloud_monitor.dao;

import com.jinkun.cloud_monitor.domain.bean.CloudClassify;
import com.jinkun.cloud_monitor.domain.request.ClassifyQueryReq;
import com.jinkun.cloud_monitor.domain.vo.ClassifyVo;
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
}