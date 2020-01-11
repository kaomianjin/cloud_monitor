package com.jinkun.cloud_monitor.controller;

import com.github.pagehelper.PageInfo;
import com.jinkun.cloud_monitor.domain.bean.CloudMonitorItems;
import com.jinkun.cloud_monitor.domain.bean.Trigger;
import com.jinkun.cloud_monitor.domain.request.*;
import com.jinkun.cloud_monitor.domain.vo.MonitotrItemVo;
import com.jinkun.cloud_monitor.domain.vo.PageView;
import com.jinkun.cloud_monitor.domain.vo.ResultInfo;
import com.jinkun.cloud_monitor.domain.vo.TriggerDetailVo;
import com.jinkun.cloud_monitor.service.IMonitorProjectService;
import com.jinkun.cloud_monitor.service.ITriggerService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/***
 * @ClassName: MonitorProjectsController
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/30 17:11
 * @version : V1.0
 */
@RestController
@RequestMapping("monitorItems")
public class MonitorProjectsController {

    @Resource
    private IMonitorProjectService monitorProjectService;
    @Resource
    private ITriggerService triggerService;


    @PostMapping("/get/batch")
    public ResultInfo<PageView<MonitotrItemVo>> seletList(@Validated @RequestBody MonitorItemsQueryReq req){

        return ResultInfo.successResultInfo(monitorProjectService.selectListVo(req));
    }

    @PostMapping("/get/one")
    public ResultInfo<CloudMonitorItems> get(@Validated @RequestBody MonitorItemsGetReq req){

        return ResultInfo.successResultInfo(monitorProjectService.get(req));
    }

    @PostMapping("/update/one")
    public ResultInfo<Boolean> update(@Validated @RequestBody MonitorItemsDetailReq req){

        return ResultInfo.result(monitorProjectService.update(req));
    }

    @PostMapping("/get/trigger/batch")
    public ResultInfo<PageView<Trigger>> selectListTriger(@Validated @RequestBody TriggerQueryReq req){

        return ResultInfo.successResultInfo(triggerService.selectList(req));
    }

    @PostMapping("/get/trigger/one")
    public ResultInfo<TriggerDetailVo> getTrigger(@Validated @RequestBody TriggerGetReq req){

        return ResultInfo.successResultInfo(triggerService.get(req));
    }

    @PostMapping("/update/trigger/one")
    public ResultInfo<Boolean> updateTrigger(@Validated @RequestBody TriggerDetailReq req){

        return ResultInfo.result(triggerService.update(req));
    }

    @PostMapping("/save/trigger/one")
    public ResultInfo<Boolean> saveTrigger(@Validated @RequestBody TriggerDetailReq req){

        return ResultInfo.result(triggerService.save(req));
    }

    @PostMapping("/delete/trigger/batch")
    public ResultInfo<Boolean> deleteTriggers(@Validated @RequestBody TriggerDeleteReq req){

        return ResultInfo.result(triggerService.deleteBatch(req));
    }

}
