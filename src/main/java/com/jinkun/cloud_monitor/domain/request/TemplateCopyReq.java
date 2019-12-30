package com.jinkun.cloud_monitor.domain.request;

import com.jinkun.cloud_monitor.domain.bean.TemplateLable;
import com.jinkun.cloud_monitor.domain.request.TemplateUnpdateReq;
import lombok.Data;

import java.util.List;

/***
 * @ClassName: TemplateCopyReq
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/29 21:34
 * @version : V1.0
 */
@Data
public class TemplateCopyReq extends TemplateUnpdateReq {

    private List<TemplateLable> templateLableList;
}
