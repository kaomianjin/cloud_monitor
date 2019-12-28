package com.jinkun.cloud_monitor.domain.request;

import com.jinkun.cloud_monitor.domain.bean.CloudService;
import com.jinkun.cloud_monitor.domain.bean.CloudType;
import com.jinkun.cloud_monitor.domain.po.AliyunVerify;
import com.jinkun.cloud_monitor.domain.po.CloudDataSourceDetail;
import com.jinkun.cloud_monitor.domain.po.HuaweiVerify;
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
public class DataSourceUpdateReq extends CloudDataSourceDetail {

    private Long id;
}
