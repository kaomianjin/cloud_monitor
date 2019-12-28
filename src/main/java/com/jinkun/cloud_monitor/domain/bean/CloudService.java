package com.jinkun.cloud_monitor.domain.bean;

public class CloudService {
    private Long id;

    private String name;

    private Long cloudTypeId;

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

    public Long getCloudTypeId() {
        return cloudTypeId;
    }

    public void setCloudTypeId(Long cloudTypeId) {
        this.cloudTypeId = cloudTypeId;
    }
}