package com.jinkun.cloud_monitor.domain.bean;

import com.jinkun.cloud_monitor.domain.request.TemplateLableAddReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotNull;

@NoArgsConstructor

@ApiModel(value = "模板标签对象" )
public class TemplateLable {

    @ApiModelProperty(value = "模板标签列表", dataType = "Long", name = "id", example = "1/新增、copy不传")
    private Long id;

    @NotNull(message = "名称不能为空")
    @ApiModelProperty(value = "模板标签名称", dataType = "String", name = "name", example = "这是一个标签名称")
    private String name;

    @ApiModelProperty(value = "模板id", dataType = "Long", name = "templateId", example = "1/copy不传")
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