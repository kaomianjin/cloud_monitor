package com.jinkun.cloud_monitor.domain.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/***
 * @ClassName: TemplateDeleteReq
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/30 9:29
 * @version : V1.0
 */
@Data
@ApiModel(value = "模板批量删除" )
public class TemplateDeleteReq {

    @NotNull(message = "模板id不能为空")
    @ApiModelProperty(value = "模板id", dataType = "List<Long>", name = "ids", example = "[1,2,3]")
    private List<Long> ids;
}
