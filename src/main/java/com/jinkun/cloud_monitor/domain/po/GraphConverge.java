package com.jinkun.cloud_monitor.domain.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/***
 * @ClassName: TimeSeriesConverges
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/30 14:55
 * @version : V1.0
 */
@Data
public class GraphConverge {

    @ApiModelProperty(value = "名称", dataType = "String", name = "name", example = "总和")
    private String name;

    @ApiModelProperty(value = "类型", dataType = "Integer", name = "type", example = "1")
    private Integer type;
}
