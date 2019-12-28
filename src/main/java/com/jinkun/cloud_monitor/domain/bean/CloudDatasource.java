package com.jinkun.cloud_monitor.domain.bean;

import com.alibaba.fastjson.JSON;
import com.jinkun.cloud_monitor.constant.CloudConstant;
import com.jinkun.cloud_monitor.domain.request.DataSourceReq;
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
    @ApiModelProperty(value = "名称", dataType = "string", example = "阿里数据源")
    private String name;
    @ApiModelProperty(value = "第几页", dataType = "int", example = "1")
    private String verificationInformation;
    @ApiModelProperty(value = "第几页", dataType = "int", example = "1")
    private String description;
    @ApiModelProperty(value = "第几页", dataType = "int",  example = "1")
    private Boolean status;
    @ApiModelProperty(value = "第几页", dataType = "int",  example = "1")
    private Date createTime;
    @ApiModelProperty(value = "第几页", dataType = "int", example = "1")
    private Date updateTime;
    @ApiModelProperty(value = "第几页", dataType = "int", example = "1")
    private String operator;
    @ApiModelProperty(value = "第几页", dataType = "int",  example = "1")
    private Boolean deleted;

    public CloudDatasource(DataSourceReq req){
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