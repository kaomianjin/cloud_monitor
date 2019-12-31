package com.jinkun.cloud_monitor.domain.bean;

import com.jinkun.cloud_monitor.domain.request.ClassifyDetailReq;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
public class CloudClassify {
    private Long id;

    private String name;

    private Boolean status;

    private Long cloudServiceId;

    private Long cloudComponentsId;

    private String description;

    public CloudClassify(ClassifyDetailReq req){
        BeanUtils.copyProperties(req,this);
    }
}