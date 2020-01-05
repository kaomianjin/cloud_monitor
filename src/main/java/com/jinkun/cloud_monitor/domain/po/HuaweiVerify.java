package com.jinkun.cloud_monitor.domain.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/***
 * @ClassName: HuaweiVerify
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/27 15:57
 * @version : V1.0
 */
@Data
public class HuaweiVerify {

    @ApiModelProperty(value = "华为云账户登录信息", dataType = "String", example = "见数据结构")
    private String account;

    @ApiModelProperty(value = "华为云账户登录信息", dataType = "String", example = "见数据结构")
    private String password;

    @ApiModelProperty(value = "华为云账户登录信息", dataType = "String", example = "cn-south-1")
    private String areaId;
}
