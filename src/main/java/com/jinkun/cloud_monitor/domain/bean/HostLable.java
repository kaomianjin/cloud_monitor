package com.jinkun.cloud_monitor.domain.bean;

public class HostLable {
    private Long id;

    private String name;

    private Long cloudHostId;

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

    public Long getCloudHostId() {
        return cloudHostId;
    }

    public void setCloudHostId(Long cloudHostId) {
        this.cloudHostId = cloudHostId;
    }
}