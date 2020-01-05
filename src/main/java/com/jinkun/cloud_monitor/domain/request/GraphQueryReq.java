package com.jinkun.cloud_monitor.domain.request;

import com.jinkun.cloud_monitor.base.BaseQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/***
 * @ClassName: GraphQueryReq
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/30 10:52
 * @version : V1.0
 */
@Data
@ApiModel(value = "获取模板下图表列表" )
public class GraphQueryReq extends BaseQuery {

    @NotNull(message = "模板id不能为空")
    @ApiModelProperty(value = "模板id", required = true, dataType = "Long", name = "templateId", example = "1")
    private Long templateId;
}
