package com.jinkun.cloud_monitor.domain.bean;

import com.alibaba.fastjson.JSON;
import com.jinkun.cloud_monitor.constant.CloudConstant;
import com.jinkun.cloud_monitor.domain.request.DataSourceSaveReq;
import com.jinkun.cloud_monitor.domain.request.DataSourceUpdateReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@NoArgsConstructor
@Data
@ApiModel(value = "云监控数据源" )
public class CloudDatasource {
    private Long id;
    @ApiModelProperty(value = "云类型id", dataType = "long", example = "公有云:1;私有云:2")
    private Long cloudTypeId;
    @ApiModelProperty(value = "云服务商id", dataType = "long",  example = "阿里云1;华为云2")
    private Long cloudServiceId;
    @ApiModelProperty(value = "数据源名称", dataType = "name", example = "阿里数据源")
    private String name;
    @ApiModelProperty(value = "验证数据json", dataType = "verificationInformation", example = "1")
    private String verificationInformation;
    @ApiModelProperty(value = "描述", dataType = "String", example = "1")
    private String description;
    @ApiModelProperty(value = "状态", dataType = "Boolean",  example = "1启用,0禁用")
    private Boolean status;
    @ApiModelProperty(value = "创建时间", dataType = "Date",  example = "1")
    private Date createTime;
    @ApiModelProperty(value = "更新时间", dataType = "Date", example = "1")
    private Date updateTime;
    @ApiModelProperty(value = "操作人", dataType = "operator", example = "1")
    private String operator;
    @ApiModelProperty(value = "删除", dataType = "int",  example = "1删除,0未删除")
    private Boolean deleted;

    public CloudDatasource(DataSourceSaveReq req){
        BeanUtils.copyProperties(req,this);
        this.cloudTypeId=req.getCloudType().getId();
        this.cloudServiceId=req.getCloudService().getId();
        if (CloudConstant.CLOUD_SERVICE_HUAWEI.equals(req.getCloudService().getName())){
            this.verificationInformation= JSON.toJSONString(req.getHuaweiVerify());
        }else if (CloudConstant.CLOUD_SERVICE_ALI.equals(req.getCloudService().getName())){
            this.verificationInformation= JSON.toJSONString(req.getAliyunVerify());
        }
        this.createTime=new Date();
        this.updateTime=new Date();
    }

    public CloudDatasource(DataSourceUpdateReq req){
        BeanUtils.copyProperties(req,this);
        this.cloudTypeId=req.getCloudType().getId();
        this.cloudServiceId=req.getCloudService().getId();
        if (CloudConstant.CLOUD_SERVICE_HUAWEI.equals(req.getCloudService().getName())){
            this.verificationInformation= JSON.toJSONString(req.getHuaweiVerify());
        }else if (CloudConstant.CLOUD_SERVICE_ALI.equals(req.getCloudService().getName())){
            this.verificationInformation= JSON.toJSONString(req.getAliyunVerify());
        }
        this.updateTime=new Date();
    }

}