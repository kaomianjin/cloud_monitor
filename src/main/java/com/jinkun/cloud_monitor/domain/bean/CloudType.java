package com.jinkun.cloud_monitor.domain.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CloudType {

    @ApiModelProperty(value = "cloudTypeId",required = true,name = "id", dataType = "Long", example = "1")
    private Long id;

    @ApiModelProperty(value = "cloudType名称",required = true,name = "name", dataType = "String", example = "公有云")
    private String name;

    @ApiModelProperty(value = "是否启用",required = true,name = "Boolean", dataType = "status", example = "1启用,0禁用")
    private Boolean status;
}