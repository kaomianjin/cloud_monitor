package com.jinkun.cloud_monitor.domain.vo;

import lombok.Data;

import java.util.List;

/***
 * @ClassName: TemplateVo
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/28 16:28
 * @version : V1.0
 */
@Data
public class TemplateVo {

    private Long id;

    private String name;

    private Integer type;

    private Integer classificationNumber;

    private Integer monitorNumber;

    private Integer triggerNumber;

    private Integer graphNumber;

    private String labels;

}
