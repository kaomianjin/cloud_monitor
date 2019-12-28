package com.jinkun.cloud_monitor.domain.bean;

public class CloudMonitorItems {
    private Long id;

    private String name;

    private String keyAssignments;

    private Boolean status;

    private String displayName;

    private String unit;

    private Integer interval;

    private Integer duration;

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

    public String getKeyAssignments() {
        return keyAssignments;
    }

    public void setKeyAssignments(String keyAssignments) {
        this.keyAssignments = keyAssignments == null ? null : keyAssignments.trim();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName == null ? null : displayName.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}