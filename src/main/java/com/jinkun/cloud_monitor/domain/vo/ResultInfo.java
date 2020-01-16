package com.jinkun.cloud_monitor.domain.vo;

import com.jinkun.cloud_monitor.constant.ResponseEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@ApiModel(value="返回结果对象", description="")
public class ResultInfo<T> implements Serializable {

    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "结果说明")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private T data;

    public static ResultInfo result(boolean flag){
        if (flag){
            return successResultInfo(true);
        }
        return failedResultInfo();
    }

    public static <T>ResultInfo<T> successResultInfo(T t){
        return setResultInfo(ResponseEnum.SUCCESS.getCode(),ResponseEnum.SUCCESS.getMsg(),t);
    }

    public static <T>ResultInfo<T> failedResultInfo(){
        return setResultInfo(ResponseEnum.FAIL.getCode(),ResponseEnum.FAIL.getMsg(),null);
    }

    public static <T>ResultInfo<T> failedResultInfo(String message){
        return setResultInfo(ResponseEnum.FAIL.getCode(),message,null);
    }

    public static <T>ResultInfo<T> failedResultInfo(int code,String message){
        return setResultInfo(code,message,null);
    }

    public static <T>ResultInfo<T> setResultInfo(int code,String message,T t){
        ResultInfo<T>resultInfo=new ResultInfo<T>();
        resultInfo.code=code;
        resultInfo.data=t;
        resultInfo.message=message;
        return  resultInfo;
    }

}
