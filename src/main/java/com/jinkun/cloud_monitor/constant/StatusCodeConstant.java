package com.jinkun.cloud_monitor.constant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/***
 * @ClassName: StatusCodeConstant
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/27 14:45
 * @version : V1.0
 */
@ApiModel(value = "返回结构说明" )
public class StatusCodeConstant {

    @ApiModelProperty(value = "请求成功码")
    public static final int CODE_SUCCESS=200;

    @ApiModelProperty(value = "错误参数请求码")
    public static final int CODE_ERRORQUEST=400;

    @ApiModelProperty(value = "未授权/没有权限码")
    public static final int CODE_UNAUTHORIZED=401;

    @ApiModelProperty(value = "错误的请求路径码")
    public static final int CODE_NOTFIND=404;

    @ApiModelProperty(value = "服务器处理异常码")
    public static final int CODE_SERVERERROR=500;

    @ApiModelProperty(value = "服务器连接超时码")
    public static final int CODE_OVERTIME=503;
}
