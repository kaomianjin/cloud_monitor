package com.jinkun.cloud_monitor.controller;

import com.jinkun.cloud_monitor.domain.bean.CloudMonitorItems;
import com.jinkun.cloud_monitor.domain.bean.Trigger;
import com.jinkun.cloud_monitor.domain.request.*;
import com.jinkun.cloud_monitor.domain.vo.MonitotrItemVo;
import com.jinkun.cloud_monitor.domain.vo.PageView;
import com.jinkun.cloud_monitor.domain.vo.ResultInfo;
import com.jinkun.cloud_monitor.domain.vo.TriggerDetailVo;
import com.jinkun.cloud_monitor.service.IMonitorProjectService;
import com.jinkun.cloud_monitor.service.ITriggerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "监控项、触发器", tags = {"监控项、触发器"})
@RequestMapping("monitorItems")
public class MonitorProjectsController {

    @Resource
    private IMonitorProjectService monitorProjectService;
    @Resource
    private ITriggerService triggerService;

    @ApiOperation(value = "根据模板id获取触发器列表", notes = "根据模板id获取触发器列表")
    @PostMapping("/template/trigger/get/batch")
    public ResultInfo<PageView<Trigger>> seletTriggerListByTemplateId(@Validated @RequestBody MonitorItemsQueryReq req){

        return ResultInfo.successResultInfo(monitorProjectService.seletTriggerListByTemplateId(req));
    }

    @ApiOperation(value = "根据模板id获取监控项列表", notes = "根据模板id获取监控项列表")
    @PostMapping("/get/batch")
    public ResultInfo<PageView<MonitotrItemVo>> seletList(@Validated @RequestBody MonitorItemsQueryReq req){

        return ResultInfo.successResultInfo(monitorProjectService.selectListVo(req));
    }

    @ApiOperation(value = "获取监控项详情", notes = "获取监控项详情")
    @PostMapping("/get/one")
    public ResultInfo<CloudMonitorItems> get(@Validated @RequestBody MonitorItemsGetReq req){

        return ResultInfo.successResultInfo(monitorProjectService.get(req));
    }

    @ApiOperation(value = "更新单个监控项信息", notes = "更新单个监控项信息")
    @PostMapping("/update/one")
    public ResultInfo<Boolean> update(@Validated @RequestBody MonitorItemsDetailReq req){

        return ResultInfo.result(monitorProjectService.update(req));
    }

    @ApiOperation(value = "根据监控项批量获取触发器", notes = "更新单个监控项信息")
    @PostMapping("/get/trigger/batch")
    public ResultInfo<PageView<Trigger>> selectListTriger(@Validated @RequestBody TriggerQueryReq req){

        return ResultInfo.successResultInfo(triggerService.selectList(req));
    }

    @ApiOperation(value = "根据id获取触发器详情", notes = "根据id获取触发器详情")
    @PostMapping("/get/trigger/one")
    public ResultInfo<TriggerDetailVo> getTrigger(@Validated @RequestBody TriggerGetReq req){

        return ResultInfo.successResultInfo(triggerService.get(req));
    }

    @ApiOperation(value = "根据id更新触发器", notes = "根据id更新触发器")
    @PostMapping("/update/trigger/one")
    public ResultInfo<Boolean> updateTrigger(@Validated @RequestBody TriggerDetailReq req){

        return ResultInfo.result(triggerService.update(req));
    }

    @ApiOperation(value = "保存触发器", notes = "保存触发器")
    @PostMapping("/save/trigger/one")
    public ResultInfo<Boolean> saveTrigger(@Validated @RequestBody TriggerDetailReq req){

        return ResultInfo.result(triggerService.save(req));
    }

    @ApiOperation(value = "批量删除触发器", notes = "批量删除触发器")
    @PostMapping("/delete/trigger/batch")
    public ResultInfo<Boolean> deleteTriggers(@Validated @RequestBody TriggerDeleteReq req){

        return ResultInfo.result(triggerService.deleteBatch(req));
    }

}
