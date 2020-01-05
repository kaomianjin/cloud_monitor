package com.jinkun.cloud_monitor.domain.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/***
 * @ClassName: GraphMonodromeConfig
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/30 14:07
 * @version : V1.0
 */
@Data
public class GraphMonodromeConfig {

    @ApiModelProperty(value = "聚合方式", dataType = "GraphConverge", name = "graphConverge", example = "见数据结构")
    private GraphConverge graphConverge;

    @ApiModelProperty(value = "图标类型", dataType = "Integer", name = "iconType", example = "1")
    private Integer iconType;

    @ApiModelProperty(value = "图标颜色", dataType = "String", name = "iconColor", example = "自己传自己用")
    private String iconColor;
}
