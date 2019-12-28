package com.jinkun.cloud_monitor.domain.bean;

public class CloudComponents {
    private Long id;

    private String name;

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