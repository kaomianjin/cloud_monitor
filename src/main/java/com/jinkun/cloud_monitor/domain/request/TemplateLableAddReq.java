package com.jinkun.cloud_monitor.domain.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/***
 * @ClassName: TemplateAddReq
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/30 10:16
 * @version : V1.0
 */
@Data
@ApiModel(value = "模板标签增加" )
public class TemplateLableAddReq {

    @NotNull(message = "模板标签名称不能为空")
    @ApiModelProperty(value = "模板标签名称", dataType = "String", name = "name", example = "这是一个模板标签名称")
    private String name;

    @NotNull(message = "模板id不能为空")
    @ApiModelProperty(value = "模板id", dataType = "Long", name = "templateId", example = "1")
    private Long templateId;
}
