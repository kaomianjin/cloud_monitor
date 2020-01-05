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

    @NotNull(message = "CloudType对象不能为空")
    @ApiModelProperty(value = "CloudType对象",required = true,name = "CloudType", dataType = "cloudType", example = "见数据结构")
    private CloudType cloudType;
    @NotNull(message = "CloudService不能为空")
    @ApiModelProperty(value = "CloudService对象",required = true,name = "cloudService",dataType = "CloudService",  example = "见数据结构")
    private CloudService cloudService;
    @NotNull(message = "名称不能为空")
    @ApiModelProperty(value = "名称",required = true, dataType = "string", example = "第一个数据源")
    private String name;
    @NotNull(message = "启用状态不能为空")
    @ApiModelProperty(value = "启用",required = true, dataType = "Boolean", example = "ture")
    private Boolean status;
    @ApiModelProperty(value = "描述",required = true, dataType = "string", example = "这是数据源描述")
    private String description;

    @ApiModelProperty(value = "华为云账户登录信息", dataType = "HuaweiVerify", example = "见数据结构")
    private HuaweiVerify  huaweiVerify;

    @ApiModelProperty(value = "阿里云账户登录信息", dataType = "AliyunVerify", example = "见数据结构")
    private AliyunVerify aliyunVerify;
}
