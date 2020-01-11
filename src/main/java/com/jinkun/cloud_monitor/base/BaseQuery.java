package com.jinkun.cloud_monitor.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/***
 * @ClassName: BaseQuery
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/27 18:03
 * @version : V1.0
 */
@Data
public class BaseQuery {

    @ApiModelProperty(value = "资源分类id", dataType = "Long", name = "id", example = "1")
    private int pageNum=1;
    @ApiModelProperty(value = "资源分类id", dataType = "Long", name = "id", example = "10")
    private int pageSize=10;

}
