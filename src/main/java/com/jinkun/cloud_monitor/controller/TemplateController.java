package com.jinkun.cloud_monitor.controller;

import com.jinkun.cloud_monitor.domain.po.*;
import com.jinkun.cloud_monitor.domain.request.*;
import com.jinkun.cloud_monitor.domain.vo.*;
import com.jinkun.cloud_monitor.service.IGraphService;
import com.jinkun.cloud_monitor.service.ITemplateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/***
 * @ClassName: TemplateController
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/28 16:06
 * @version : V1.0
 */
@Api(value = "云监控模板", tags = {"云监控模板"})
@RestController
@RequestMapping("template")
public class TemplateController {

    @Resource
    private ITemplateService templateService;
    @Resource
    private IGraphService graphService;

    @PostMapping("/get/batch")
    @ApiOperation(value = "模板列表获取", notes = "批量获取")
    public ResultInfo<PageView<TemplateVo>> selectList(@Validated @RequestBody TemplateQueryReq req){

        return ResultInfo.successResultInfo(templateService.selectList(req));
    }

    @PostMapping("/save/copy")
    @ApiOperation(value = "模板拷贝", notes = "选取内置模板进行copy")
    public ResultInfo<Boolean> copyTemplate(@Validated @RequestBody TemplateCopyReq req){

        return ResultInfo.result(templateService.copyTemplate(req));
    }

    @PostMapping("/get/one")
    @ApiOperation(value = "模板详情", notes = "详情获取")
    public ResultInfo<TemplateDetail> getOne(@Validated @RequestBody TemplateGetReq req){

        return ResultInfo.successResultInfo(templateService.get(req));
    }

    @PostMapping("/update/one")
    @ApiOperation(value = "模板修改", notes = "模板更改")
    public ResultInfo<Boolean> updateTemplate(@Validated @RequestBody TemplateUpdateReq req){

        return ResultInfo.result(templateService.update(req));
    }

    @PostMapping("/batch")
    @ApiOperation(value = "模板批量删除", notes = "批量删除")
    public ResultInfo<Boolean> deleteTemplates(@Validated @RequestBody TemplateDeleteReq req){

        return ResultInfo.result(templateService.deleteTemplates(req));
    }

    @PostMapping("/save/templateLable/one")
    @ApiOperation(value = "模板标签新增", notes = "单个模板标签新增")
    public ResultInfo<Boolean> addTemplateLable(@Validated @RequestBody TemplateLableAddReq req){

        return ResultInfo.result(templateService.addTemplateLable(req));
    }

    @PostMapping("/update/templateLable/one")
    @ApiOperation(value = "模板标签更新", notes = "单个模板标签更新")
    public ResultInfo<Boolean> updateTemplateLable(@Validated @RequestBody TemplateLableDetailReq req){

        return ResultInfo.result(templateService.updateTemplateLable(req));
    }

    @PostMapping("/delete/templateLable/one")
    @ApiOperation(value = "模板标签删除", notes = "单个模板标签删除")
    public ResultInfo<Boolean> deleteTemplateLable(@Validated @RequestBody TemplateLableDeleteReq req){

        return ResultInfo.result(templateService.deleteTemplateLableOne(req));
    }

    @PostMapping("/save/graph/one")
    @ApiOperation(value = "模板图表新增", notes = "新增单个图表配置")
    public ResultInfo<Boolean> saveGraph(@Validated @RequestBody GraphAddReq req){

        return ResultInfo.result(graphService.saveGraph(req));
    }

    @PostMapping("/get/graph/batch")
    @ApiOperation(value = "模板图表列表获取", notes = "模板获取图表列表")
    public ResultInfo<PageView<GraphVo>> selectList(@Validated @RequestBody GraphQueryReq req){

        return ResultInfo.successResultInfo(graphService.selectList(req));
    }

    @PostMapping("/get/graph/one")
    @ApiOperation(value = "模板图表详情", notes = "模板获取单个图表配置详情")
    public ResultInfo<GraphDetail> getGraphDetail(@Validated @RequestBody GraphGetReq req){

        return ResultInfo.successResultInfo(graphService.getDetail(req));
    }

    @PostMapping("/update/graph/one")
    @ApiOperation(value = "模板图表修改", notes = "修改单个图表配置")
    public ResultInfo<Boolean> updateGraph(@Validated @RequestBody GraphUpdateReq req){

        return ResultInfo.result(graphService.updateGraph(req));
    }

    @PostMapping("/delete/graph/batch")
    @ApiOperation(value = "模板图表批量删除", notes = "批量删除图表")
    public  ResultInfo<Boolean> deleteBatchGraph(@Validated @RequestBody GraphDeleteReq req){

        return ResultInfo.result(graphService.deleteBatchGraph(req));
    }

    @PostMapping("/get/classify/batch")
    @ApiOperation(value = "获取木板下的分类", notes = "获取木板下的分类")
    public  ResultInfo<List<TemplateClassifyVo>> selectBatchClassify(@Validated @RequestBody TemplateClassifyQuery req){

        return ResultInfo.successResultInfo(templateService.selectBatchClassify(req));
    }
}

