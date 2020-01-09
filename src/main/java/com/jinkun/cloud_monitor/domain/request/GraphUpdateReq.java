package com.jinkun.cloud_monitor.domain.request;

import com.jinkun.cloud_monitor.domain.po.GraphDetail;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 * @ClassName: GraphUpdateReq
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/30 16:09
 * @version : V1.0
 */
@Data
@NoArgsConstructor
@ApiModel(value = "图表配置更新req" )
public class GraphUpdateReq extends GraphDetail {
}
