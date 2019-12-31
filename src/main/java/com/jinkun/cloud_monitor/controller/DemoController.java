package com.jinkun.cloud_monitor.controller;

import com.github.pagehelper.PageInfo;
import com.jinkun.cloud_monitor.domain.bean.Demo;
import com.jinkun.cloud_monitor.domain.request.DemoQuery;
import com.jinkun.cloud_monitor.domain.vo.ResultInfo;
import com.jinkun.cloud_monitor.service.IDemoService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/***
 * @ClassName: DemoController
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/26 11:36
 * @version : V1.0
 */
@RestController
@RequestMapping("demo")
public class DemoController {

    @Resource
    private IDemoService demoService;

    @RequestMapping("/name")
    public String get(){
        return demoService.get().toString();
    }

    @RequestMapping("/all")
    public ResultInfo<PageInfo<Demo>> selectList(@RequestBody DemoQuery query){
        return ResultInfo.successResultInfo(demoService.selectList(query));
    }
}
