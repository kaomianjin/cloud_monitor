package com.jinkun.cloud_monitor.constant;

/**
 @Author : juzhic
 @Date 14:39 2019/12/27
 @version : V1.0
 @Description
*/
@SuppressWarnings("unchecked")
public enum ResponseEnum {

    //服务器内部错误
    FAIL(StatusCodeConstant.CODE_SERVERERROR,"服务器内部错误"),
    //返回成功
    SUCCESS(StatusCodeConstant.CODE_SUCCESS,"成功"),
    //请求内容中参数格式错误
    PARAMETER_ERROR(StatusCodeConstant.CODE_ERRORQUEST,"参数格式错误");

    //返回的状态码
    private int code;

    //返回信息说明
    private String msg;

    ResponseEnum(int code, String msg) {
        this.code=code;
        this.msg=msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
