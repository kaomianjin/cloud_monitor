package com.jinkun.cloud_monitor.domain.request;

import com.jinkun.cloud_monitor.base.BaseQuery;
import lombok.Data;

/***
 * @ClassName: GraphQueryReq
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/30 10:52
 * @version : V1.0
 */
@Data
public class GraphQueryReq extends BaseQuery {

    private Long templateId;
}
