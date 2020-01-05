package com.jinkun.cloud_monitor.domain.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CloudService {

    @ApiModelProperty(value = "cloudServiceId",required = true,name = "id", dataType = "Long", example = "1")
    private Long id;
    @ApiModelProperty(value = "cloudService名称",required = true,name = "name", dataType = "String", example = "redis")
    private String name;
    @ApiModelProperty(value = "cloudTypeId",required = true,name = "cloudTypeId", dataType = "Long", example = "1")
    private Long cloudTypeId;
}