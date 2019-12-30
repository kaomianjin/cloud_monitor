package com.jinkun.cloud_monitor.controller;

import com.jinkun.cloud_monitor.service.IMonitorProjectService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/***
 * @ClassName: MonitorProjectsController
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/30 17:11
 * @version : V1.0
 */
@RestController
public class MonitorProjectsController {

    @Resource
    private IMonitorProjectService monitorProjectService;
}
