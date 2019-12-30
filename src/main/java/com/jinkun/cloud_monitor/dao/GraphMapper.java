package com.jinkun.cloud_monitor.dao;

import com.jinkun.cloud_monitor.domain.bean.Graph;
import com.jinkun.cloud_monitor.domain.request.GraphQueryReq;
import com.jinkun.cloud_monitor.domain.vo.GraphVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GraphMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Graph record);

    int insertSelective(Graph record);

    Graph selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Graph record);

    int updateByPrimaryKey(Graph record);

    List<Long> selectIdsByParameter(@Param("req") GraphQueryReq req);

    List<GraphVo> selectListVoByParameter(@Param("ids")List<Long> ids);

    int verifyRepeat(@Param("graph")Graph graph);

    int deleteBatchByIds(@Param("ids")List<Long> ids);
}