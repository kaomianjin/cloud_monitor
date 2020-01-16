package com.jinkun.cloud_monitor.domain.bean;

import com.jinkun.cloud_monitor.domain.request.ResourceLableSaveReq;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
public class ResourceLable {

    @ApiModelProperty(value = "资源标签id", dataType = "Long", name = "id", example = "1")
    private Long id;

    @ApiModelProperty(value = "资源标签名称", dataType = "String", name = "name", example = "这是一个资源标签名")
    private String name;

    @ApiModelProperty(value = "资源id=resourceId", dataType = "Long", name = "cloudHostId", example = "1")
    private Long cloudHostId;

    public ResourceLable(ResourceLable lable){
        BeanUtils.copyProperties(lable,this);
    }

    public ResourceLable(ResourceLableSaveReq req){
        BeanUtils.copyProperties(req,this);
    }
}