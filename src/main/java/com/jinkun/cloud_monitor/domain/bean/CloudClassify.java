package com.jinkun.cloud_monitor.domain.bean;

import com.jinkun.cloud_monitor.domain.request.ClassifyDetailReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@ApiModel(value = "资源分类详情")
public class CloudClassify {

    @ApiModelProperty(value = "资源分类id", dataType = "Long", name = "id", example = "1")
    private Long id;

    @NotNull(message = "资源分类名称不能为空")
    @ApiModelProperty(value = "资源分类名称", required = true, dataType = "String", name = "name", example = "第一个资源分类")
    private String name;

    @NotNull(message = "需要标明启用禁用")
    @ApiModelProperty(value = "资源分类id", required = true, dataType = "Boolean", name = "status", example = "true")
    private Boolean status;

    @NotNull(message = "需要标明属于哪个云下")
    @ApiModelProperty(value = "云服务商id", required = true, dataType = "Long", name = "cloudServiceId", example = "1")
    private Long cloudServiceId;

    @NotNull(message = "需要标明属于哪个云组件下")
    @ApiModelProperty(value = "云组件id", required = true, dataType = "Long", name = "cloudComponentsId", example = "1")
    private Long cloudComponentsId;

    @ApiModelProperty(value = "分类描述", required = true, dataType = "String", name = "description", example = "这是一个描述")
    private String description;

    public CloudClassify(ClassifyDetailReq req){
        BeanUtils.copyProperties(req,this);
    }
}