package com.jinkun.cloud_monitor.domain.vo;

import com.jinkun.cloud_monitor.domain.bean.CloudService;
import com.jinkun.cloud_monitor.domain.bean.CloudType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/***
 * @ClassName: CloudDataSourceVo
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/28 14:08
 * @version : V1.0
 */
@Data
@ApiModel(value = "数据源列表查询")
public class CloudDataSourceVo {

    private Long id;

    @ApiModelProperty(value = "数据源名称", required = true, dataType = "String", name = "name", example = "数据源1")
    private String name;

    @ApiModelProperty(value = "云商类型", required = true, dataType = "CloudService", name = "cloudService", example = "见结构")
    private CloudService cloudService;

    @ApiModelProperty(value = "云类型", required = true, dataType = "CloudType", name = "cloudType", example = "见结构")
    private CloudType cloudType;

    @ApiModelProperty(value = "分类名称", required = true, dataType = "Boolean", name = "status", example = "1启用:0禁用")
    private Boolean status;

    @ApiModelProperty(value = "账户状态", required = true, dataType = "Boolean", name = "accountStatus", example = "1正常:0异常")
    private Boolean accountStatus;

    @ApiModelProperty(value = "同步情况", required = true, dataType = "Boolean", name = "sync", example = "1正常:0异常")
    private Boolean sync;
}
