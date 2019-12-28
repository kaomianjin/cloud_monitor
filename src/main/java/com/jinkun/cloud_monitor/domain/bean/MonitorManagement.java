package com.jinkun.cloud_monitor.domain.bean;

public class MonitorManagement {
    private Long id;

    private Long cloudServiceId;

    private Long cloudComponentsId;

    private Long cloudDatasourceId;

    private Boolean monitor;

    private Boolean auto;

    private Long templateId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getCloudDatasourceId() {
        return cloudDatasourceId;
    }

    public void setCloudDatasourceId(Long cloudDatasourceId) {
        this.cloudDatasourceId = cloudDatasourceId;
    }

    public Boolean getMonitor() {
        return monitor;
    }

    public void setMonitor(Boolean monitor) {
        this.monitor = monitor;
    }

    public Boolean getAuto() {
        return auto;
    }

    public void setAuto(Boolean auto) {
        this.auto = auto;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }
}