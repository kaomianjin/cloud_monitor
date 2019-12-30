package com.jinkun.cloud_monitor.domain.request;

import lombok.Data;

import java.util.List;

/***
 * @ClassName: TemplateDeleteReq
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/30 9:29
 * @version : V1.0
 */
@Data
public class TemplateDeleteReq {

    private List<Long> ids;
}
