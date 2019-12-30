package com.jinkun.cloud_monitor.domain.po;

import lombok.Data;

import java.util.List;

/***
 * @ClassName: GraphTimeSeriesConfig
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/30 13:52
 * @version : V1.0
 */
@Data
public class GraphTimeSeriesConfig {

    private GraphConverge graphConverge;

    private Integer iconType;

    private String iconColor;

    private List<Markline> marklineList;


}
