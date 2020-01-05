package com.jinkun.cloud_monitor.controller;

import com.github.pagehelper.PageInfo;
import com.jinkun.cloud_monitor.domain.bean.CloudComponents;
import com.jinkun.cloud_monitor.domain.bean.CloudService;
import com.jinkun.cloud_monitor.domain.bean.CloudType;
import com.jinkun.cloud_monitor.domain.po.ClassifyDetail;
import com.jinkun.cloud_monitor.domain.request.*;
import com.jinkun.cloud_monitor.domain.vo.ClassifyVo;
import com.jinkun.cloud_monitor.domain.vo.ResultInfo;
import com.jinkun.cloud_monitor.service.IClassifyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/***
 * @ClassName: ClassifyController
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/30 17:20
 * @version : V1.0
 */
@Api(value = "云分类", tags = {"云分类"})
@RestController
@RequestMapping("classify")
public class ClassifyController {

    @Resource
    private IClassifyService classifyService;


    @PostMapping("/get/cloudType")
    @ApiOperation(value = "云类型列表查询", notes = "公有云/私有云/容器云")
    public ResultInfo<List<CloudType>> selectCloudType(){

        return ResultInfo.successResultInfo(classifyService.selectCloudType());
    }

    @PostMapping("/get/cloudService")
    @ApiOperation(value = "云服务列表查询", notes = "/华为云/阿里云")
    public ResultInfo<List<CloudService>> selectCloudService(@Validated @RequestBody CloudServiceQueryReq req){

        return ResultInfo.successResultInfo(classifyService.selectCloudService(req));
    }

    @PostMapping("/get/cloudComponents")
    @ApiOperation(value = "云组件列表查询", notes = "redis/rds/mysql")
    public ResultInfo<List<CloudComponents>> selectComponents(@Validated @RequestBody ComponentsQueryReq req){

        return ResultInfo.successResultInfo(classifyService.selectComponents(req));
    }

    @PostMapping("/get/batch")
    @ApiOperation(value = "云分类列表查询", notes = "列表的批量获取")
    public ResultInfo<PageInfo<ClassifyVo>> selectList(@Validated @RequestBody ClassifyQueryReq req){

        return ResultInfo.successResultInfo(classifyService.selectList(req));
    }

    @PostMapping("/get/one")
    @ApiOperation(value = "云类型详情查询", notes = "详情")
    public ResultInfo<ClassifyDetail> getOne(@Validated @RequestBody ClassifyGetReq req){

        return ResultInfo.successResultInfo(classifyService.getDetail(req));
    }

    @PostMapping("/save/one")
    @ApiOperation(value = "云类型新增", notes = "详情保存")
    public ResultInfo<Boolean> saveClassify(@Validated @RequestBody ClassifyDetailReq req){

        return ResultInfo.result(classifyService.save(req));
    }

    @PostMapping("/update/one")
    @ApiOperation(value = "云类型更新", notes = "详情更新")
    public ResultInfo<Boolean> updateClassify(@Validated @RequestBody ClassifyDetailReq req){

        return ResultInfo.result(classifyService.update(req));
    }

    @PostMapping("/delete/batch")
    @ApiOperation(value = "云类型批量删除", notes = "批量删除")
    public ResultInfo<Boolean> deleteBatchClassify(@Validated @RequestBody ClassifyDeleteReq req){

        return ResultInfo.result(classifyService.deleteBatch(req));
    }
}
