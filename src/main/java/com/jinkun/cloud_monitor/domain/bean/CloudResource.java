package com.jinkun.cloud_monitor.domain.bean;

public class CloudResource {
    private Long id;

    private String name;

    private String cloudHostId;

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

    public String getCloudHostId() {
        return cloudHostId;
    }

    public void setCloudHostId(String cloudHostId) {
        this.cloudHostId = cloudHostId == null ? null : cloudHostId.trim();
    }
}