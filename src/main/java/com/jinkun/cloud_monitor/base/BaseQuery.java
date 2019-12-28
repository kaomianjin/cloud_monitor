package com.jinkun.cloud_monitor.base;

import lombok.Data;

/***
 * @ClassName: BaseQuery
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/27 18:03
 * @version : V1.0
 */
@Data
public class BaseQuery {

    private int pageNum=1;
    private int pageSize=10;
}
