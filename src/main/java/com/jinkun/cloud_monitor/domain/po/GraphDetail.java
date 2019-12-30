package com.jinkun.cloud_monitor.domain.po;

import com.alibaba.fastjson.JSON;
import com.jinkun.cloud_monitor.constant.GraphConfigEnum;
import com.jinkun.cloud_monitor.domain.bean.Graph;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

/***
 * @ClassName: GraphDetail
 * @Description: TODO
 * @Author: juzhic
 * @Date: 2019/12/30 13:43
 * @version : V1.0
 */
@NoArgsConstructor
@Data
public class GraphDetail{

    private Long id;

    private String name;

    private Integer type;

    private Long templateId;

    private GraphTimeSeriesConfig graphTimeSeriesConfig;

    private GraphPieConfig graphPieConfig;

    private GraphMonodromeConfig graphMonodromeConfig;

    private String description;

    public GraphDetail(Graph graph){

        BeanUtils.copyProperties(graph,this);

        if (GraphConfigEnum.GRAPH_TIMESERIES_CONFIG.getType().equals(graph.getType())){
            this.graphTimeSeriesConfig=JSON.parseObject(graph.getConfiguration(),GraphTimeSeriesConfig.class);
        }else if (GraphConfigEnum.GRAPH_PIE_CONFIG.getType().equals(graph.getType())){
            this.graphPieConfig=JSON.parseObject(graph.getConfiguration(),GraphPieConfig.class);
        }else if (GraphConfigEnum.GRAPH_MONODROME_CONFIG.getType().equals(graph.getType())){
            this.graphMonodromeConfig=JSON.parseObject(graph.getConfiguration(),GraphMonodromeConfig.class);
        }

    }
}
