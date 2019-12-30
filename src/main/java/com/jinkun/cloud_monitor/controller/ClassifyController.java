package com.jinkun.cloud_monitor.controller;

import com.github.pagehelper.PageInfo;
import com.jinkun.cloud_monitor.domain.request.ClassifyQueryReq;
import com.jinkun.cloud_monitor.domain.vo.ClassifyVo;
import com.jinkun.cloud_monitor.domain.vo.ResultInfo;
import com.jinkun.cloud_monitor.service.IClassifyService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/***
 * @ClassName: ClassifyController
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/30 17:20
 * @version : V1.0
 */
@RestController
@RequestMapping("classify")
public class ClassifyController {

    @Resource
    private IClassifyService classifyService;

    @GetMapping("/batch")
    public ResultInfo<PageInfo<ClassifyVo>> selectList(@Validated @RequestBody ClassifyQueryReq req){

        return ResultInfo.successResultInfo(classifyService.selectList(req));
    }
}
