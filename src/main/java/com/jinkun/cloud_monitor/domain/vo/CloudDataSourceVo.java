package com.jinkun.cloud_monitor.domain.vo;

import com.jinkun.cloud_monitor.domain.bean.CloudService;
import com.jinkun.cloud_monitor.domain.bean.CloudType;
import lombok.Data;

/***
 * @ClassName: CloudDataSourceVo
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/28 14:08
 * @version : V1.0
 */
@Data
public class CloudDataSourceVo {

    private Long id;

    private String name;

    private CloudService cloudService;

    private CloudType cloudType;

    private Boolean status;

    private Boolean accountStatus;

    private Boolean sync;
}
