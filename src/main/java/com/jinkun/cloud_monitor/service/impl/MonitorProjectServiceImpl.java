package com.jinkun.cloud_monitor.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jinkun.cloud_monitor.dao.CloudMonitorItemsMapper;
import com.jinkun.cloud_monitor.dao.TriggerMapper;
import com.jinkun.cloud_monitor.domain.bean.CloudMonitorItems;
import com.jinkun.cloud_monitor.domain.bean.Trigger;
import com.jinkun.cloud_monitor.domain.request.MonitorItemsDetailReq;
import com.jinkun.cloud_monitor.domain.request.MonitorItemsGetReq;
import com.jinkun.cloud_monitor.domain.request.MonitorItemsQueryReq;
import com.jinkun.cloud_monitor.domain.vo.MonitotrItemVo;
import com.jinkun.cloud_monitor.domain.vo.PageView;
import com.jinkun.cloud_monitor.service.IMonitorProjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/***
 * @ClassName: MonitorProjectServiceImpl
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/30 17:16
 * @version : V1.0
 */
@Service
public class MonitorProjectServiceImpl implements IMonitorProjectService {

    @Resource
    private CloudMonitorItemsMapper cloudMonitorItemsMapper;

    @Resource
    private TriggerMapper triggerMapper;

    @Override
    public PageView<MonitotrItemVo> selectListVo(MonitorItemsQueryReq req) {

        PageHelper.startPage(req.getPageNum(),req.getPageSize());
        List<MonitotrItemVo> entities=cloudMonitorItemsMapper.selectListVo(req);
        return new PageView(new PageInfo(entities));
    }

    @Override
    public CloudMonitorItems get(MonitorItemsGetReq req) {

        return cloudMonitorItemsMapper.selectByPrimaryKey(req.getId());
    }

    @Override
    public Boolean update(MonitorItemsDetailReq req) {

        return cloudMonitorItemsMapper.updateByReq(req)==1;
    }

    @Override
    public PageView<Trigger> seletTriggerListByTemplateId(MonitorItemsQueryReq req) {

        PageHelper.startPage(req.getPageNum(),req.getPageSize());
        List<Trigger> entities=triggerMapper.selectListByTemplateId(req.getId());
        return new PageView(new PageInfo(entities));
    }
}
