package com.jinkun.cloud_monitor.domain.bean;

public class Trigger {
    private Integer id;

    private Long monitorItemsId;

    private String name;

    private String grade;

    private String diaplayName;

    private Boolean status;

    private String expression;

    private Byte multipleEvents;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getMonitorItemsId() {
        return monitorItemsId;
    }

    public void setMonitorItemsId(Long monitorItemsId) {
        this.monitorItemsId = monitorItemsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public String getDiaplayName() {
        return diaplayName;
    }

    public void setDiaplayName(String diaplayName) {
        this.diaplayName = diaplayName == null ? null : diaplayName.trim();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression == null ? null : expression.trim();
    }

    public Byte getMultipleEvents() {
        return multipleEvents;
    }

    public void setMultipleEvents(Byte multipleEvents) {
        this.multipleEvents = multipleEvents;
    }
}