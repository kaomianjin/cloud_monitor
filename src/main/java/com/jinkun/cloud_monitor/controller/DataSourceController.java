package com.jinkun.cloud_monitor.controller;

import com.github.pagehelper.PageInfo;
import com.jinkun.cloud_monitor.domain.vo.CloudDataSourceDetailVo;
import com.jinkun.cloud_monitor.domain.request.*;
import com.jinkun.cloud_monitor.domain.vo.CloudDataSourceVo;
import com.jinkun.cloud_monitor.domain.vo.ResultInfo;
import com.jinkun.cloud_monitor.service.IDataSourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

/***
 * @ClassName: DataSourceController
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/27 14:12
 * @version : V1.0
 */
@RestController
@Api(value = "数据源", tags = {"云监控数据源"})
@RequestMapping("dataSource")
public class DataSourceController {

    @Resource
    private IDataSourceService dataSourceService;

    /**
     @Author juzhic
     @Date 14:00 2019/12/28
     @version : V1.0
     @Description :创建数据源
    */
    @PostMapping("/save/one")
    @ApiOperation(value = "新增云监控数据源", notes = "单个保存")
    public ResultInfo<Boolean> createDataSource(@Validated @RequestBody DataSourceSaveReq req){

        return ResultInfo.successResultInfo(dataSourceService.save(req));
    }

    /**
     @Author juzhic
     @Date 14:03 2019/12/28
     @version : V1.0
     @Description : 批量查询
    */
    @PostMapping("/get/batch")
    @ApiOperation(value = "获取云监控数据源列表", notes = "批量查询")
    public ResultInfo<PageInfo<CloudDataSourceVo>> selectList(@Validated @RequestBody DataSourceQueryReq req){

        return ResultInfo.successResultInfo(dataSourceService.selectList(req));
    }

    /**
     @Author juzhic
     @Date 16:01 2019/12/28
     @version : V1.0
     @Description :获取单个数据源详情
    */
    @PostMapping("/get/one")
    @ApiOperation(value = "获取单个云监控数据源", notes = "获取单个数据源详情")
    public ResultInfo<CloudDataSourceDetailVo> selectOne(@Validated @RequestBody DataSourceGetReq req){

        return ResultInfo.successResultInfo(dataSourceService.selectOne(req));
    }

    /**
     @Author juzhic
     @Date 14:03 2019/12/28
     @version : V1.0
     @Description :更新一个数据源
    */
    @PostMapping("/update/one")
    @ApiOperation(value = "修改单个云监控数据源", notes = "更新一个数据源")
    public ResultInfo<Boolean> updateDataSource(@Validated @RequestBody DataSourceUpdateReq req){

        return ResultInfo.successResultInfo(dataSourceService.update(req));
    }

    /**
     @Author juzhic
     @Date 14:04 2019/12/28
     @version : V1.0
     @Description :批量删除数据源
    */
    @PostMapping("/delete/batch")
    @ApiOperation(value = "批量删除云监控数据源", notes = "批量删除数据源")
    public ResultInfo<Boolean> deleteDataSource(@Validated @RequestBody DataSourceDeleteReq req){

        return ResultInfo.successResultInfo(dataSourceService.delete(req));
    }

}

