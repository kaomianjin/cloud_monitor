package com.jinkun.cloud_monitor.domain.po;

import com.jinkun.cloud_monitor.domain.bean.Template;
import com.jinkun.cloud_monitor.domain.bean.TemplateLable;
import io.swagger.annotations.ApiModelProperty;
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

    @ApiModelProperty(value = "模板id", dataType = "Long", name = "id", example = "1")
    private Long id;

    @ApiModelProperty(value = "模板名称", dataType = "String", name = "name", example = "这是一个模板名称")
    private String name;

    @ApiModelProperty(value = "模板描述", dataType = "String", name = "description", example = "123")
    private String description;

    private List<TemplateLable> templateLableList;

    public TemplateDetail(Template template, List<TemplateLable> templateLableList){
        BeanUtils.copyProperties(template,this);
        this.templateLableList=templateLableList;
    }
}
