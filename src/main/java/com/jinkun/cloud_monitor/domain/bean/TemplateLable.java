package com.jinkun.cloud_monitor.domain.bean;

import com.jinkun.cloud_monitor.domain.request.TemplateLableAddReq;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@NoArgsConstructor
public class TemplateLable {
    private Long id;

    private String name;

    private Long templateId;

    public TemplateLable(TemplateLableAddReq req){
        BeanUtils.copyProperties(req,this);
    }

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

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }
}