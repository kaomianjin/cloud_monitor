package com.jinkun.cloud_monitor.domain.po;

import com.jinkun.cloud_monitor.domain.bean.TemplateLable;
import lombok.Data;

import javax.annotation.Resource;
import java.util.List;

/***
 * @ClassName: TemplateCopyReq
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/29 21:34
 * @version : V1.0
 */
@Data
public class TemplateCopyReq extends TemplateUnpdateReq{

    private List<TemplateLable> templateLableList;
}
