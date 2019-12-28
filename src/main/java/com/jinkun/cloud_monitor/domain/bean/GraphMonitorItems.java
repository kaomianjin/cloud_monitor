package com.jinkun.cloud_monitor.domain.bean;

public class GraphMonitorItems {
    private Long id;

    private Long graphId;

    private Long monitorItemsId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGraphId() {
        return graphId;
    }

    public void setGraphId(Long graphId) {
        this.graphId = graphId;
    }

    public Long getMonitorItemsId() {
        return monitorItemsId;
    }

    public void setMonitorItemsId(Long monitorItemsId) {
        this.monitorItemsId = monitorItemsId;
    }
}