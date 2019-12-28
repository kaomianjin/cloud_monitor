package com.jinkun.cloud_monitor.domain.request;

import lombok.Data;

import java.util.List;

/***
 * @ClassName: DataSourceDeleteReq
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/27 17:39
 * @version : V1.0
 */
@Data
public class DataSourceDeleteReq {
    private List<Long> ids;
}
