package com.jinkun.cloud_monitor.constant;

import com.jinkun.cloud_monitor.domain.po.GraphMonodromeConfig;
import com.jinkun.cloud_monitor.domain.po.GraphPieConfig;
import com.jinkun.cloud_monitor.domain.po.GraphTimeSeriesConfig;

/**
 @Author juzhic
 @Date 14:17 2019/12/30
 @version : V1.0
 @Description : 图形配置 按类型对应各自class
*/
public enum GraphConfigEnum {

    //时序图
    GRAPH_TIMESERIES_CONFIG(1, GraphTimeSeriesConfig.class),

    //饼图
    GRAPH_PIE_CONFIG(2,GraphPieConfig.class),

    //单值图
    GRAPH_MONODROME_CONFIG(3, GraphMonodromeConfig.class);

    private Integer type;

    private Class cls;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Class getCls() {
        return cls;
    }

    public void setCls(Class cls) {
        this.cls = cls;
    }

    GraphConfigEnum(Integer type, Class cls) {
        this.type = type;
        this.cls = cls;
    }

    public static void get(){

    }
}
