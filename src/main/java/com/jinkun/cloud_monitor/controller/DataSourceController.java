package com.jinkun.cloud_monitor.controller;

import com.github.pagehelper.PageInfo;
import com.jinkun.cloud_monitor.domain.po.CloudDataSourceDetailVo;
import com.jinkun.cloud_monitor.domain.request.*;
import com.jinkun.cloud_monitor.domain.vo.CloudDataSourceVo;
import com.jinkun.cloud_monitor.domain.vo.ResultInfo;
import com.jinkun.cloud_monitor.service.IDataSourceService;
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
    @PostMapping("/one")
    public ResultInfo<Boolean> createDataSource(@Validated @RequestBody DataSourceReq req){

        return ResultInfo.successResultInfo(dataSourceService.save(req));
    }

    /**
     @Author juzhic
     @Date 14:03 2019/12/28
     @version : V1.0
     @Description : 批量查询
    */
    @GetMapping("/batch")
    public ResultInfo<PageInfo<CloudDataSourceVo>> selectList(@Validated @RequestBody DataSourceQueryAllReq req){

        return ResultInfo.successResultInfo(dataSourceService.selectList(req));
    }

    /**
     @Author juzhic
     @Date 16:01 2019/12/28
     @version : V1.0
     @Description :获取单个数据源详情
    */
    @GetMapping("/one")
    public ResultInfo<CloudDataSourceDetailVo> selectOne(@Validated @RequestBody DataSourceQueryOneReq req){

        return ResultInfo.successResultInfo(dataSourceService.selectOne(req));
    }

    /**
     @Author juzhic
     @Date 14:03 2019/12/28
     @version : V1.0
     @Description :更新一个数据源
    */
    @PutMapping("/one")
    public ResultInfo<Boolean> updateDataSource(@Validated @RequestBody DataSourceUpdateReq req){

        return ResultInfo.successResultInfo(dataSourceService.update(req));
    }

    /**
     @Author juzhic
     @Date 14:04 2019/12/28
     @version : V1.0
     @Description :批量删除数据源
    */
    @DeleteMapping("/one")
    public ResultInfo<Boolean> deleteDataSource(@Validated @RequestBody DataSourceDeleteReq req){

        return ResultInfo.successResultInfo(dataSourceService.delete(req));
    }

}

