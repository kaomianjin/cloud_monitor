package com.jinkun.cloud_monitor.dao;

import com.jinkun.cloud_monitor.domain.bean.MonitorManagement;
import com.jinkun.cloud_monitor.domain.request.CloudTypeManagementQueryReq;
import com.jinkun.cloud_monitor.domain.vo.CloudTypeManagementVo;
import com.jinkun.cloud_monitor.domain.vo.ResultInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MonitorManagementMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MonitorManagement record);

    int insertSelective(MonitorManagement record);

    MonitorManagement selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MonitorManagement record);

    int updateByPrimaryKey(MonitorManagement record);

    List<CloudTypeManagementVo> queryByParamete(@Param("req") CloudTypeManagementQueryReq req);

    int insertBatch(@Param("list") List<MonitorManagement> monitorManagements);

    void deleteByDataSourceIds(@Param("cloudDataSourceIds") List<Long> cloudDataSourceIds);

    int updateBatch(@Param("list") List<CloudTypeManagementVo> managementVos);

    List<MonitorManagement> selectAllAuto();

    List<MonitorManagement> selectAllAutoTemplate();
}