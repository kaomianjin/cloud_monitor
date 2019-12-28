package com.jinkun.cloud_monitor.service;

import com.github.pagehelper.PageInfo;
import com.jinkun.cloud_monitor.domain.bean.Demo;
import com.jinkun.cloud_monitor.domain.request.DemoQuery;

import java.util.List;

/***
 * @ClassName: DemoServiceImpl
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/26 14:24
 * @version : V1.0
 */
public interface IDemoService {

    Demo get();

    PageInfo<Demo> selectList(DemoQuery query);
}
