package com.jinkun.cloud_monitor.exception;

import com.jinkun.cloud_monitor.constant.StatusCodeConstant;
import lombok.Data;

/***
 * @ClassName: ParameterException
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/11/13 10:03
 * @version : V1.0
 */
@Data
public class ParameterException extends RuntimeException {

    private int code;

    public ParameterException(){

    }

    public ParameterException(int code,String message){
        super(message);
        this.code=code;
    }

    public ParameterException(String message){
        this(StatusCodeConstant.CODE_ERRORQUEST,message);
    }

}

