package com.jinkun.cloud_monitor.domain.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/***
 * @ClassName: GraphDeleteReq
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/30 16:34
 * @version : V1.0
 */
@Data
@ApiModel(value = "图表的批量删除" )
public class GraphDeleteReq {


    @NotNull(message = "图表id不能为空")
    @ApiModelProperty(value = "图表id", required = true, dataType = "List<Long> ", name = "ids", example = "[1,2,3]")
    private List<Long> ids;
}

