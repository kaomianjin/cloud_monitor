package com.jinkun.cloud_monitor.domain.request;

import com.jinkun.cloud_monitor.base.BaseQuery;
import lombok.Data;

/***
 * @ClassName: TemplateQueryReq
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/28 16:31
 * @version : V1.0
 */
@Data
public class TemplateQueryReq extends BaseQuery {

    private Long cloudTypeId;

    private Long cloudServiceId;

}
