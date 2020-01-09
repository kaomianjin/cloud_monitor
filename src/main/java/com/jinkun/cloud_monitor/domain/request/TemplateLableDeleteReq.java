package com.jinkun.cloud_monitor.domain.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/***
 * @ClassName: TemplateLableDeleteReq
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/29 21:03
 * @version : V1.0
 */
@Data
@ApiModel(value = "模板标签删除req" )
public class TemplateLableDeleteReq {

    @NotNull(message = "模板标签id不能为空")
    @ApiModelProperty(value = "模板标签id", dataType = "Long", name = "id", example = "1")
    private Long id;
}
