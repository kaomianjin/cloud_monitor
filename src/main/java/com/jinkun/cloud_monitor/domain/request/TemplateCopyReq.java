package com.jinkun.cloud_monitor.domain.request;

import com.jinkun.cloud_monitor.domain.bean.TemplateLable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/***
 * @ClassName: TemplateCopyReq
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/29 21:34
 * @version : V1.0
 */
@Data
@ApiModel(value = "模板克隆req" )
public class TemplateCopyReq{


    @NotNull(message = "模板id不能为空")
    @ApiModelProperty(value = "模板id", required = true, dataType = "Long", name = "id", example = "1")
    private Long id;

    @NotNull(message = "模板名称不能为空")
    @ApiModelProperty(value = "模板名称", required = true, dataType = "String", name = "name", example = "这是个模板名称")
    private String name;

    @ApiModelProperty(value = "描述", required = true, dataType = "String", name = "description", example = "这是模板描述")
    private String description;

    @ApiModelProperty(value = "模板标签列表", dataType = "List<TemplateLable>", name = "templateLableList", example = "见数据结构")
    private List<TemplateLable> templateLableList;
}
