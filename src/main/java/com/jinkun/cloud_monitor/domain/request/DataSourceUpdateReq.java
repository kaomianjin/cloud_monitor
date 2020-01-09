package com.jinkun.cloud_monitor.domain.request;

import com.jinkun.cloud_monitor.domain.bean.CloudService;
import com.jinkun.cloud_monitor.domain.bean.CloudType;
import com.jinkun.cloud_monitor.domain.po.AliyunVerify;
import com.jinkun.cloud_monitor.domain.po.CloudDataSourceDetail;
import com.jinkun.cloud_monitor.domain.po.HuaweiVerify;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/***
 * @ClassName: DataSourceUpReq
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/27 17:36
 * @version : V1.0
 */
@Data
@ApiModel(value = "数据源配置更新req" )
public class DataSourceUpdateReq extends CloudDataSourceDetail {

    @NotNull(message = "数据源id不能为空")
    @ApiModelProperty(value = "数据源id", required = true, dataType = "Long", name = "id", example = "1")
    private Long id;
}
