package com.jinkun.cloud_monitor.domain.vo;

import com.jinkun.cloud_monitor.constant.CloudConstant;
import com.jinkun.cloud_monitor.domain.bean.CloudDatasource;
import com.jinkun.cloud_monitor.domain.po.CloudDataSourceDetail;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

/***
 * @ClassName: CloudDataSourceDetailVo
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/28 15:20
 * @version : V1.0
 */
@NoArgsConstructor
@Data
public class CloudDataSourceDetailVo extends CloudDataSourceDetail {

    private Long id;

}
