package com.jinkun.cloud_monitor.controller;

import com.jinkun.cloud_monitor.domain.request.TemplateQueryReq;
import com.jinkun.cloud_monitor.domain.vo.ResultInfo;
import com.jinkun.cloud_monitor.domain.vo.TemplateVo;
import com.jinkun.cloud_monitor.service.ITemplateService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/***
 * @ClassName: TemplateController
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/28 16:06
 * @version : V1.0
 */
@RestController
@RequestMapping("template")
public class TemplateController {

    @Resource
    private ITemplateService templateService;

    @RequestMapping("/page")
    public ResultInfo<List<TemplateVo>> selectList(@Validated @RequestBody TemplateQueryReq req){

        return ResultInfo.successResultInfo(templateService.selectList(req));
    }
}
