package com.jinkun.cloud_monitor.domain.bean;

import com.alibaba.fastjson.JSON;
import com.jinkun.cloud_monitor.domain.request.TriggerDetailReq;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
public class Trigger {

    @ApiModelProperty(value = "id", required = true, dataType = "Integer", name = "id", example = "1")
    private Integer id;

    @ApiModelProperty(value = "监控项id", required = true, dataType = "Long", name = "monitorItemsId", example = "1")
    private Long monitorItemsId;

    @ApiModelProperty(value = "触发器名称", required = true, dataType = "String", name = "name", example = "这是一个触发器名称")
    private String name;

    @ApiModelProperty(value = "触发器等级", required = true, dataType = "Integer", name = "name", example = "这是一个分类列表")
    private Integer grade;

    @ApiModelProperty(value = "触发器规则", required = true, dataType = "String", name = "name", example = "这是一个分类列表")
    private String diaplayName;

    @ApiModelProperty(value = "启用禁用", required = true, dataType = "String", name = "name", example = "这是一个分类列表")
    private boolean status;

    @ApiModelProperty(value = "触发器规则", required = true, dataType = "String", name = "name", example = "这是一个分类列表")
    private String expression;

    @ApiModelProperty(value = "多重时间生成", required = true, dataType = "String", name = "name", example = "这是一个分类列表")
    private boolean multipleEvents;

    public Trigger(TriggerDetailReq req){
        BeanUtils.copyProperties(req,this);
        this.expression= JSON.toJSONString(req.getTriggerRule());
    }
}