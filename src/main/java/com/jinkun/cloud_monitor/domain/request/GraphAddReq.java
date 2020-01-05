package com.jinkun.cloud_monitor.domain.request;

import com.jinkun.cloud_monitor.domain.po.GraphDetail;
import com.jinkun.cloud_monitor.domain.po.GraphMonodromeConfig;
import com.jinkun.cloud_monitor.domain.po.GraphPieConfig;
import com.jinkun.cloud_monitor.domain.po.GraphTimeSeriesConfig;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/***
 * @ClassName: GraphAddReq
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/30 15:55
 * @version : V1.0
 */
@Data
@ApiModel(value = "模板下图表创建" )
public class GraphAddReq extends GraphDetail {

}
