package com.jinkun.cloud_monitor.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/***
 * @ClassName: ClassifyVo
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/30 18:54
 * @version : V1.0
 */
@Data
@ApiModel(value = "分类列表列表查询")
public class ClassifyVo {

    private Long id;

    @ApiModelProperty(value = "分类名称", required = true, dataType = "String", name = "name", example = "这是一个分类列表")
    private String name;

    @ApiModelProperty(value = "分类状态", required = true, dataType = "Integer", name = "status", example = "1/启用;0禁用")
    private Integer status;
    @ApiModelProperty(value = "云商名称", required = true, dataType = "String", name = "cloudServiceName", example = "华为云/阿里云")
    private String cloudServiceName;

    @ApiModelProperty(value = "组件名称", required = true, dataType = "String", name = "componentName", example = "mysql/redis")
    private String componentName;

    @ApiModelProperty(value = "模板名称", required = true, dataType = "String", name = "templateName", example = "这是关联的模板")
    private String templateName;

    @ApiModelProperty(value = "关联资源数量", required = true, dataType = "Integer", name = "resourceNumber", example = "11")
    private Integer resourceNumber;
}


