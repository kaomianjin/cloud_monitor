package com.jinkun.cloud_monitor.constant;

/***
 * @ClassName: GraphConstant
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/30 14:47
 * @version : V1.0
 */
public enum  GraphConvergeTypeEnum {

    //平均值
    AVG(1,"平均值"),
    //最大值
    MAX(2,"最大值"),
    //最小值
    MIN(3,"最小值"),
    //总和
    SUM(4,"总和"),
    //最后更新的数值
    LAST(5,"最后更新");

    private Integer type;

    private String name;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    GraphConvergeTypeEnum(Integer type, String name) {
        this.type = type;
        this.name = name;
    }
}
