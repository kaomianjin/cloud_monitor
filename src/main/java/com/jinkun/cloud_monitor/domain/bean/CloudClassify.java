package com.jinkun.cloud_monitor.domain.bean;

public class CloudClassify {
    private Long id;

    private String name;

    private Boolean status;

    private Long cloudServiceId;

    private Long cloudComponentsId;

    private Long templateId;

    private String description;

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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Long getCloudServiceId() {
        return cloudServiceId;
    }

    public void setCloudServiceId(Long cloudServiceId) {
        this.cloudServiceId = cloudServiceId;
    }

    public Long getCloudComponentsId() {
        return cloudComponentsId;
    }

    public void setCloudComponentsId(Long cloudComponentsId) {
        this.cloudComponentsId = cloudComponentsId;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}