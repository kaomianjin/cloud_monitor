package com.jinkun.cloud_monitor.domain.request;

import lombok.Data;

/***
 * @ClassName: TemplateAddReq
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/30 10:16
 * @version : V1.0
 */
@Data
public class TemplateLableAddReq {

    private String name;

    private Long templateId;
}
