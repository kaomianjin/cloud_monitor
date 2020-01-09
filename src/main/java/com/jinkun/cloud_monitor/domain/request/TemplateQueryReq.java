package com.jinkun.cloud_monitor.domain.request;

import com.jinkun.cloud_monitor.base.BaseQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/***
 * @ClassName: TemplateQueryReq
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/28 16:31
 * @version : V1.0
 */
@Data
@ApiModel(value = "模板列表分页查询req" )
public class TemplateQueryReq extends BaseQuery {

    @NotNull(message = "云id不能为空")
    @ApiModelProperty(value = "云服务商id", dataType = "Long", name = "cloudServiceId", example = "1")
    private Long cloudServiceId;

    @NotNull(message = "云组件id不能为空")
    @ApiModelProperty(value = "云组件id", dataType = "Long", name = "cloudComponentsId", example = "1")
    private Long cloudComponentsId;

}
