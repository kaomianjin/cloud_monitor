package com.jinkun.cloud_monitor.domain.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/***
 * @ClassName: DataSourceDeleteReq
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/27 17:39
 * @version : V1.0
 */
@Data
@ApiModel(value = "批量删除数据源")
public class DataSourceDeleteReq {

    @NotNull(message = "数据源id不能为空")
    @ApiModelProperty(value = "数据源id", required = true, dataType = "Long", name = "ids", example = "[1,2,3]")
    private List<Long> ids;
}
