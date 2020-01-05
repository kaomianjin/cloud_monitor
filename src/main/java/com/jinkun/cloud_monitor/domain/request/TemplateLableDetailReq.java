package com.jinkun.cloud_monitor.domain.request;

import com.jinkun.cloud_monitor.domain.bean.TemplateLable;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/***
 * @ClassName: TemplateLableDetailReq
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/29 20:49
 * @version : V1.0
 */
@Data
@ApiModel(value = "单个模板标签更新" )
public class TemplateLableDetailReq extends TemplateLable {

}
