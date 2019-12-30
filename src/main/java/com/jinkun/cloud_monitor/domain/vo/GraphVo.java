package com.jinkun.cloud_monitor.domain.vo;

import lombok.Data;

/***
 * @ClassName: GraphVo
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/30 10:48
 * @version : V1.0
 */
@Data
public class GraphVo {

    private Long id;

    private String name;

    private Integer type;

    private Long templateId;

    private Integer monitorNumber;
}
