package com.jinkun.cloud_monitor.domain.bean;

import io.swagger.annotations.ApiModelProperty;

public class CloudComponents {

    @ApiModelProperty(value = "云组件id", required = true, dataType = "Long", name = "id", example = "1")
    private Long id;

    @ApiModelProperty(value = "云组件名称", required = true, dataType = "String", name = "name", example = "这是一个组件名称")
    private String name;

    @ApiModelProperty(value = "云商id", required = true, dataType = "Long", name = "cloudServiceId", example = "1")
    private Long cloudServiceId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getCloudServiceId() {
        return cloudServiceId;
    }

    public void setCloudServiceId(Long cloudServiceId) {
        this.cloudServiceId = cloudServiceId;
    }
}