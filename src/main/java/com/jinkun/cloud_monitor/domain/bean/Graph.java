package com.jinkun.cloud_monitor.domain.bean;

import com.alibaba.fastjson.JSON;
import com.jinkun.cloud_monitor.constant.GraphConfigEnum;
import com.jinkun.cloud_monitor.domain.request.GraphAddReq;
import com.jinkun.cloud_monitor.domain.request.GraphUpdateReq;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@NoArgsConstructor
@Data
public class Graph {
    private Long id;

    private Integer type;

    private String name;

    private Long templateId;

    private String description;

    private String configuration;


    public Graph(GraphUpdateReq req){
        BeanUtils.copyProperties(req,this);

        if (GraphConfigEnum.GRAPH_TIMESERIES_CONFIG.getType().equals(req.getType())){
            this.configuration=JSON.toJSONString(req.getGraphTimeSeriesConfig());
        }else if (GraphConfigEnum.GRAPH_PIE_CONFIG.getType().equals(req.getType())){
            this.configuration=JSON.toJSONString(req.getGraphPieConfig());
        }else if (GraphConfigEnum.GRAPH_MONODROME_CONFIG.getType().equals(req.getType())){
            this.configuration=JSON.toJSONString(req.getGraphMonodromeConfig());
        }
    }

    public Graph(GraphAddReq req){
        BeanUtils.copyProperties(req,this);

        if (GraphConfigEnum.GRAPH_TIMESERIES_CONFIG.getType().equals(req.getType())){
            this.configuration=JSON.toJSONString(req.getGraphTimeSeriesConfig());
        }else if (GraphConfigEnum.GRAPH_PIE_CONFIG.getType().equals(req.getType())){
            this.configuration=JSON.toJSONString(req.getGraphPieConfig());
        }else if (GraphConfigEnum.GRAPH_MONODROME_CONFIG.getType().equals(req.getType())){
            this.configuration=JSON.toJSONString(req.getGraphMonodromeConfig());
        }
    }
}