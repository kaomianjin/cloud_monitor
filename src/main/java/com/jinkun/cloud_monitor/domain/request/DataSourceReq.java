package com.jinkun.cloud_monitor.domain.request;

import com.jinkun.cloud_monitor.domain.po.CloudDataSourceDetail;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/***
 * @ClassName: DataSourceCreate
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/27 15:33
 * @version : V1.0
 */
@Data
@ApiModel(value = "数据源创建" )
public class DataSourceReq extends CloudDataSourceDetail{

}
