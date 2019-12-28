package com.jinkun.cloud_monitor.domain.po;

import com.jinkun.cloud_monitor.domain.bean.CloudService;
import com.jinkun.cloud_monitor.domain.bean.CloudType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/***
 * @ClassName: DataSourceDetail
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/28 15:13
 * @version : V1.0
 */
@Data
public class CloudDataSourceDetail {

    @NotNull(message = "登录名不能为空")
    @ApiModelProperty(value = "云类型id", dataType = "long", example = "公有云:1;私有云:2")
    private CloudType cloudType;
    @NotNull(message = "登录名不能为空")
    @ApiModelProperty(value = "云服务商id", dataType = "long",  example = "阿里云1;华为云2")
    private CloudService cloudService;
    @NotNull(message = "登录名不能为空")
    @ApiModelProperty(value = "名称", dataType = "string", example = "第一个数据源")
    private String name;
    @NotNull(message = "登录名不能为空")
    @ApiModelProperty(value = "启用", dataType = "string", example = "ture")
    private Boolean status;
    @NotNull(message = "登录名不能为空")
    @ApiModelProperty(value = "描述", dataType = "string", example = "这是不一样的数据源")
    private String description;

    private HuaweiVerify  huaweiVerify;

    private AliyunVerify aliyunVerify;
}
