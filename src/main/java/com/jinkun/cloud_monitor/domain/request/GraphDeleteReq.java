package com.jinkun.cloud_monitor.domain.request;

import lombok.Data;

import java.util.List;

/***
 * @ClassName: GraphDeleteReq
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/30 16:34
 * @version : V1.0
 */
@Data
public class GraphDeleteReq {

    private List<Long> ids;
}

