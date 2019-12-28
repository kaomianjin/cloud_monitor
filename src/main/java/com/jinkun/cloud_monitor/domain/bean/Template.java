package com.jinkun.cloud_monitor.domain.bean;

import java.util.Date;

public class Template {
    private Long id;

    private String name;

    private Long cloudTypeId;

    private Long cloudComponentsId;

    private Integer type;

    private String description;

    private Date createTime;

    private Date updateTime;

    private String operator;

    private Boolean deleted;

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

    public Long getCloudComponentsId() {
        return cloudComponentsId;
    }

    public void setCloudComponentsId(Long cloudComponentsId) {
        this.cloudComponentsId = cloudComponentsId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}