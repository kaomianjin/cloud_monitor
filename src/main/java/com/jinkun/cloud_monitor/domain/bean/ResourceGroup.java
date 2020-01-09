package com.jinkun.cloud_monitor.domain.bean;

import com.jinkun.cloud_monitor.domain.request.ResourceGroupSaveReq;
import com.jinkun.cloud_monitor.domain.request.ResourceGroupUpdateReq;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class ResourceGroup {
    private Long id;

    private String name;

    private String description;

    private Date createTime;

    private Date updateTime;

    private String operator;

    private Boolean deleted;

    public ResourceGroup(ResourceGroupSaveReq req){
        this.name=req.getName();
        this.description=req.getDescription();
        this.createTime=new Date();
        this.updateTime=new Date();
    }

    public ResourceGroup(ResourceGroupUpdateReq req){
        this.id=req.getId();
        this.name=req.getName();
        this.description=req.getDescription();
        this.createTime=new Date();
        this.updateTime=new Date();
    }

}