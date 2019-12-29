package com.jinkun.cloud_monitor.constant;

import lombok.NoArgsConstructor;

/***
 * @ClassName: TemplateContant
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/29 21:38
 * @version : V1.0
 */
@NoArgsConstructor
public enum  TemplateEnum {

    //内置模板
    BUILT_IN_TEMPLATE(0,"内置"),

    //内置模板
    PERSONAL_TEMPLATE(1,"个人");

    private int type;

    private String name;

    TemplateEnum(int type, String name) {
        this.type=type;
        this.name=name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
