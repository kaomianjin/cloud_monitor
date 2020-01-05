package com.jinkun.cloud_monitor.domain.bean;

import com.alibaba.fastjson.JSON;
import com.jinkun.cloud_monitor.domain.request.TriggerDetailReq;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
public class Trigger {
    private Integer id;

    private Long monitorItemsId;

    private String name;

    private String grade;

    private String diaplayName;

    private Boolean status;

    private String expression;

    private Boolean multipleEvents;

    public Trigger(TriggerDetailReq req){
        BeanUtils.copyProperties(req,this);
        this.expression= JSON.toJSONString(req.getTriggerRule());
    }
}