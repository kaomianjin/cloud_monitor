package com.jinkun.cloud_monitor.domain.po;

import com.alibaba.fastjson.JSON;
import com.jinkun.cloud_monitor.constant.GraphConfigEnum;
import com.jinkun.cloud_monitor.domain.bean.Graph;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotNull;

/***
 * @ClassName: GraphDetail
 * @Description: TODO
 * @Author: juzhic
 * @Date: 2019/12/30 13:43
 * @version : V1.0
 */
@NoArgsConstructor
@Data
@ApiModel(value = "图表配置详情" )
public class GraphDetail{

    @ApiModelProperty(value = "数据源id", dataType = "Long", name = "id", example = "1")
    private Long id;

    @NotNull(message = "name不能为空")
    @ApiModelProperty(value = "name", required = true, dataType = "String", name = "name", example = "这是一个图标名称")
    private String name;

    @NotNull(message = "type不能为空")
    @ApiModelProperty(value = "type", required = true, dataType = "Integer", name = "type", example = "1")
    private Integer type;

    @NotNull(message = "模板id不能为空")
    @ApiModelProperty(value = "模板id", required = true, dataType = "Long", name = "templateId", example = "1")
    private Long templateId;

    @ApiModelProperty(value = "时序图配置", dataType = "GraphTimeSeriesConfig", name = "graphTimeSeriesConfig", example = "见数据结构")
    private GraphTimeSeriesConfig graphTimeSeriesConfig;

    @ApiModelProperty(value = "饼状图配置", dataType = "GraphPieConfig", name = "graphPieConfig", example = "见数据结构")
    private GraphPieConfig graphPieConfig;

    @ApiModelProperty(value = "单值图配置", dataType = "GraphMonodromeConfig", name = "graphMonodromeConfig", example = "见数据结构")
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
