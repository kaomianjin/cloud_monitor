package com.jinkun.cloud_monitor.domain.request;

import lombok.Data;

/***
 * @ClassName: TemplateUnpdateReq
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/29 20:38
 * @version : V1.0
 */
@Data
public class TemplateUnpdateReq{
    private Long id;

    private String name;

    private String description;
}
