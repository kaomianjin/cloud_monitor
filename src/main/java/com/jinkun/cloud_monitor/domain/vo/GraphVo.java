package com.jinkun.cloud_monitor.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/***
 * @ClassName: GraphVo
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/30 10:48
 * @version : V1.0
 */
@Data
@ApiModel(value = "图表详情查询")
public class GraphVo {

    private Long id;

    @ApiModelProperty(value = "图表名称", required = true, dataType = "String", name = "name", example = "这是一个图表名称")
    private String name;

    @ApiModelProperty(value = "图表类型", required = true, dataType = "Integer", name = "type", example = "1时序,2饼图,3单值")
    private Integer type;

    @ApiModelProperty(value = "模板id", required = true, dataType = "Long", name = "templateId", example = "1")
    private Long templateId;

    @ApiModelProperty(value = "关联监控项数量", required = true, dataType = "Integer", name = "monitorNumber", example = "3")
    private Integer monitorNumber;
}
