package com.jinkun.cloud_monitor.controller;

import com.github.pagehelper.PageInfo;
import com.jinkun.cloud_monitor.domain.po.*;
import com.jinkun.cloud_monitor.domain.request.*;
import com.jinkun.cloud_monitor.domain.vo.GraphVo;
import com.jinkun.cloud_monitor.domain.vo.ResultInfo;
import com.jinkun.cloud_monitor.domain.vo.TemplateVo;
import com.jinkun.cloud_monitor.service.IGraphService;
import com.jinkun.cloud_monitor.service.ITemplateService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/***
 * @ClassName: TemplateController
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/28 16:06
 * @version : V1.0
 */
@RestController
@RequestMapping("template")
public class TemplateController {

    @Resource
    private ITemplateService templateService;
    @Resource
    private IGraphService graphService;

    @GetMapping("/batch")
    public ResultInfo<PageInfo<TemplateVo>> selectList(@Validated @RequestBody TemplateQueryReq req){

        return ResultInfo.successResultInfo(templateService.selectList(req));
    }

    @PostMapping("/copy")
    public ResultInfo<Boolean> copyTemplate(@Validated @RequestBody TemplateCopyReq req){

        return ResultInfo.result(templateService.copyTemplate(req));
    }

    @GetMapping("/one")
    public ResultInfo<TemplateDetail> getOne(@Validated @RequestBody TemplateDetailReq req){

        return ResultInfo.successResultInfo(templateService.get(req));
    }

    @PutMapping("/one")
    public ResultInfo<Boolean> updateTemplate(@Validated @RequestBody TemplateUnpdateReq req){

        return ResultInfo.result(templateService.update(req));
    }

    @DeleteMapping("/batch")
    public ResultInfo<Boolean> deleteTemplates(@Validated @RequestBody TemplateDeleteReq req){

        return ResultInfo.result(templateService.deleteTemplates(req));
    }

    @PostMapping("/templateLable/one")
    public ResultInfo<Boolean> addTemplateLable(@Validated @RequestBody TemplateLableAddReq req){

        return ResultInfo.result(templateService.addTemplateLable(req));
    }

    @PutMapping("/templateLable/one")
    public ResultInfo<Boolean> updateTemplateLable(@Validated @RequestBody TemplateLableDetailReq req){

        return ResultInfo.result(templateService.updateTemplateLable(req));
    }

    @DeleteMapping("/templateLable/one")
    public ResultInfo<Boolean> deleteTemplateLable(@Validated @RequestBody TemplateLableDeleteReq req){

        return ResultInfo.result(templateService.deleteTemplateLableOne(req));
    }

    @PostMapping("/graph/one")
    public ResultInfo<Boolean> saveGraph(@Validated @RequestBody GraphAddReq req){

        return ResultInfo.result(graphService.saveGraph(req));
    }

    @GetMapping("/graph/batch")
    public ResultInfo<PageInfo<GraphVo>> selectList(@Validated @RequestBody GraphQueryReq req){

        return ResultInfo.successResultInfo(graphService.selectList(req));
    }

    @GetMapping("/graph/one")
    public ResultInfo<GraphDetail> getGraphDetail(@Validated @RequestBody GraphDetailReq req){

        return ResultInfo.successResultInfo(graphService.getDetail(req));
    }

    @PutMapping("/graph/one")
    public ResultInfo<Boolean> updateGraph(@Validated @RequestBody GraphUpdateReq req){

        return ResultInfo.result(graphService.updateGraph(req));
    }

    @DeleteMapping("/graph/batch")
    public  ResultInfo<Boolean> deleteBatchGraph(@Validated @RequestBody GraphDeleteReq req){

        return ResultInfo.result(graphService.deleteBatchGraph(req));
    }
}

