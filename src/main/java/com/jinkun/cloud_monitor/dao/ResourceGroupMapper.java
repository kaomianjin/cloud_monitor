package com.jinkun.cloud_monitor.dao;

import com.jinkun.cloud_monitor.domain.bean.RelevanceGroupResource;
import com.jinkun.cloud_monitor.domain.bean.ResourceGroup;
import com.jinkun.cloud_monitor.domain.request.ResourceGroupQueryReq;
import com.jinkun.cloud_monitor.domain.vo.ResourceGroupVo;
import com.jinkun.cloud_monitor.domain.vo.TemplateVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResourceGroupMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ResourceGroup record);

    int insertSelective(ResourceGroup record);

    ResourceGroup selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ResourceGroup record);

    int updateByPrimaryKey(ResourceGroup record);

    List<ResourceGroupVo> selectResourceGroupVo(@Param("req") ResourceGroupQueryReq req);

    int insertRelevance(@Param("relevanceGroupResources") List<RelevanceGroupResource> relevanceGroupResources);

    int deleteBatchByIds(@Param("ids") List<Long> ids);
}