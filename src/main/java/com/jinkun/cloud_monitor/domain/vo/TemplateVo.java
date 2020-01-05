package com.jinkun.cloud_monitor.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "模板列表查询")
public class TemplateVo {

    private Long id;

    @ApiModelProperty(value = "模板名称", required = true, dataType = "String", name = "name", example = "这是一个模板名")
    private String name;

    @ApiModelProperty(value = "模板类型", required = true, dataType = "Integer", name = "type", example = "0内置,1个人")
    private Integer type;

    @ApiModelProperty(value = "关联分类数量", required = true, dataType = "Integer", name = "classificationNumber", example = "5")
    private Integer classificationNumber;

    @ApiModelProperty(value = "关联监控项数量", required = true, dataType = "Integer", name = "monitorNumber", example = "3")
    private Integer monitorNumber;

    @ApiModelProperty(value = "关联触发器数量", required = true, dataType = "Integer", name = "name", example = "3")
    private Integer triggerNumber;

    @ApiModelProperty(value = "关联图表数量", required = true, dataType = "Integer", name = "name", example = "3")
    private Integer graphNumber;

    @ApiModelProperty(value = "模板标签", required = true, dataType = "String", name = "name", example = "标签1,标签2")
    private String labels;

}
