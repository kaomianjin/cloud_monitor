package com.jinkun.cloud_monitor.domain.vo;

import io.swagger.models.auth.In;
import lombok.Data;

/***
 * @ClassName: ClassifyVo
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/30 18:54
 * @version : V1.0
 */
@Data
public class ClassifyVo {

    private Long id;

    private String name;

    private String cloudServiceName;

    private String componentName;

    private String templateName;

    private Integer resourceNumber;
}

