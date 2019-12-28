package com.jinkun.cloud_monitor.exception;

import com.jinkun.cloud_monitor.constant.StatusCodeConstant;
import lombok.Data;

/***
 * @ClassName: ServeException
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/11/13 11:16
 * @version : V1.0
 */
@Data
public class ServeException extends RuntimeException{
    private int code;

    public ServeException(){

    }

    public ServeException(int code,String message){
        super(message);
        this.code=code;
    }

    public ServeException(String message){
        this(StatusCodeConstant.CODE_SERVERERROR,message);
    }
}
