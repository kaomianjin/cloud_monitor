package com.jinkun.cloud_monitor.domain.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
public class ResourceLable {
    private Long id;

    private String name;

    private Long cloudHostId;

    public ResourceLable(ResourceLable lable){
        BeanUtils.copyProperties(lable,this);
    }
}