package com.jinkun.cloud_monitor.domain.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/***
 * @ClassName: Markline
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/30 14:28
 * @version : V1.0
 */
@Data
public class Markline {

    @ApiModelProperty(value = "标记线名称", dataType = "String", name = "name", example = "这是一条警告线")
    private String name;

    @ApiModelProperty(value = "标记线触发值", dataType = "Integer", name = "value", example = "100")
    private Integer value;
}
