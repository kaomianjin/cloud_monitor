package com.jinkun.cloud_monitor.domain.bean;

public class TemplateMonitorItems {
    private Long id;

    private Long templateId;

    private Long monitorItemsId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public Long getMonitorItemsId() {
        return monitorItemsId;
    }

    public void setMonitorItemsId(Long monitorItemsId) {
        this.monitorItemsId = monitorItemsId;
    }
}