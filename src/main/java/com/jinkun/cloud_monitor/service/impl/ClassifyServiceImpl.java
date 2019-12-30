package com.jinkun.cloud_monitor.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jinkun.cloud_monitor.dao.CloudClassifyMapper;
import com.jinkun.cloud_monitor.domain.request.ClassifyQueryReq;
import com.jinkun.cloud_monitor.domain.vo.ClassifyVo;
import com.jinkun.cloud_monitor.service.IClassifyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/***
 * @ClassName: ClassifyServiceImpl
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/30 17:19
 * @version : V1.0
 */
@Service
public class ClassifyServiceImpl implements IClassifyService {

    @Resource
    private CloudClassifyMapper cloudClassifyMapper;

    @Override
    public PageInfo<ClassifyVo> selectList(ClassifyQueryReq req) {

        PageHelper.startPage(req.getPageNum(),req.getPageSize());
        List<Long>ids=cloudClassifyMapper.selectIds(req);
        List<ClassifyVo>classifyVos;
        if(ids.size()==0){
            classifyVos=new ArrayList<>();
        }else{
            classifyVos=cloudClassifyMapper.selectListVoByParameter(ids);
        }
        return new PageInfo<>(classifyVos);
    }
}
