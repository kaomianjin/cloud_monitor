package com.jinkun.cloud_monitor.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jinkun.cloud_monitor.dao.DemoMapper;
import com.jinkun.cloud_monitor.domain.bean.Demo;
import com.jinkun.cloud_monitor.domain.request.DemoQuery;
import com.jinkun.cloud_monitor.domain.vo.PageView;
import com.jinkun.cloud_monitor.service.IDemoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/***
 * @ClassName: DemoServiceImpl
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/26 14:25
 * @version : V1.0
 */
@Service
public class DemoServiceImpl implements IDemoService {

    @Resource
    private DemoMapper demoMapper;

    @Override
    public Demo get() {
        return demoMapper.selectByPrimaryKey(1l);
    }

    @Override
    public PageView<Demo> selectList(DemoQuery query) {
        PageHelper.startPage(query.getPageNum(),query.getPageSize());
        List<Demo> entities=demoMapper.queryByParams(query);
        return new PageView<>(new PageInfo(entities));
    }

    @Override
    public boolean save() {

        Demo demo=new Demo();
        demoMapper.insert(demo);
        System.out.println(demo.getId());
        return true;
    }
}
