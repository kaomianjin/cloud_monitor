package com.jinkun.cloud_monitor.domain.po;

import com.jinkun.cloud_monitor.domain.bean.Template;
import com.jinkun.cloud_monitor.domain.bean.TemplateLable;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.List;

/***
 * @ClassName: TemplateDetail
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/29 20:17
 * @version : V1.0
 */
@NoArgsConstructor
@Data
public class TemplateDetail {

    private Long id;

    private String name;

    private String description;

    private List<TemplateLable> templateLableList;

    public TemplateDetail(Template template,List<TemplateLable> templateLableList){
        BeanUtils.copyProperties(template,this);
        this.templateLableList=templateLableList;
    }
}
