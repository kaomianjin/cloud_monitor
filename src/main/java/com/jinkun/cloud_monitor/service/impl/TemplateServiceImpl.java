package com.jinkun.cloud_monitor.service.impl;

import com.jinkun.cloud_monitor.dao.TemplateMapper;
import com.jinkun.cloud_monitor.domain.bean.Template;
import com.jinkun.cloud_monitor.domain.request.TemplateQueryReq;
import com.jinkun.cloud_monitor.domain.vo.TemplateVo;
import com.jinkun.cloud_monitor.service.ITemplateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/***
 * @ClassName: TemplateServiceImpl
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/28 16:08
 * @version : V1.0
 */
@Service
public class TemplateServiceImpl implements ITemplateService {

    @Resource
    private TemplateMapper templateMapper;

    @Override
    public List<TemplateVo> selectList(TemplateQueryReq req) {

        List<Template> templates=templateMapper.selectListByParameter(req);
        return null;

    }
}
