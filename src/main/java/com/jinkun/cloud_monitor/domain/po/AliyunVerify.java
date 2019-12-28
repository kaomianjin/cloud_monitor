package com.jinkun.cloud_monitor.domain.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/***
 * @ClassName: AliyunVerify
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/27 15:56
 * @version : V1.0
 */
@Data
public class AliyunVerify {

    @ApiModelProperty(value = "AccessKey", dataType = "string", example = "XIUBXIHAVJKX")
    private String key;
    @ApiModelProperty(value = "Secret", dataType = "string", example = "SAFGQXKJQBQWE ")
    private String secret;

    private String ragionArea;
}
