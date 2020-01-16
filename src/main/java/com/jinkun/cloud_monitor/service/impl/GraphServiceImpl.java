package com.jinkun.cloud_monitor.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jinkun.cloud_monitor.dao.CloudClassifyMapper;
import com.jinkun.cloud_monitor.dao.CloudClassifyTemplateMapper;
import com.jinkun.cloud_monitor.dao.GraphMapper;
import com.jinkun.cloud_monitor.domain.bean.Graph;
import com.jinkun.cloud_monitor.domain.po.GraphDetail;
import com.jinkun.cloud_monitor.domain.request.*;
import com.jinkun.cloud_monitor.domain.vo.GraphVo;
import com.jinkun.cloud_monitor.domain.vo.PageView;
import com.jinkun.cloud_monitor.domain.vo.TemplateClassifyVo;
import com.jinkun.cloud_monitor.service.IGraphService;
import com.jinkun.cloud_monitor.utils.AssertUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/***
 * @ClassName: GraphServiceImpl
 * @Description: TODO
 * @Auther: juzhic
 * @Date: 2019/12/30 10:55
 * @version : V1.0
 */
@Service
public class GraphServiceImpl implements IGraphService {

    @Resource
    private GraphMapper graphMapper;
    @Resource
    private CloudClassifyMapper cloudClassifyMapper;

    @Override
    public PageView<GraphVo> selectList(GraphQueryReq req) {

        PageHelper.startPage(req.getPageNum(),req.getPageSize());
        List<Long> ids=graphMapper.selectIdsByParameter(req);
        List<GraphVo>graphVos;
        if(ids.size()==0){
            graphVos=new ArrayList<>();
        }else{
            graphVos=graphMapper.selectListVoByParameter(ids);
        }
        return new PageView(new PageInfo(graphVos));
    }

    @Override
    public GraphDetail getDetail(GraphGetReq req) {

        Graph graph=graphMapper.selectByPrimaryKey(req.getId());

        return new GraphDetail(graph);

    }

    @Override
    public boolean saveGraph(GraphAddReq req) {
        Graph graph=new Graph(req);
        boolean repeat =graphMapper.verifyRepeat(graph)>0;
        AssertUtil.isTrue(repeat,"该模板下图标名重复");
        return graphMapper.insert(graph)==1;

    }

    @Override
    public boolean updateGraph(GraphUpdateReq req) {
        Graph graph=new Graph(req);
        boolean repeat =graphMapper.verifyRepeat(graph)>0;
        AssertUtil.isTrue(repeat,"该模板下图标名重复");
        graphMapper.updateByPrimaryKeySelective(graph);
        return true;
    }

    @Override
    public boolean deleteBatchGraph(GraphDeleteReq req) {

        AssertUtil.isTrue(req.getIds().size()==0,"没有任何删除选项");

        graphMapper.deleteBatchByIds(req.getIds());

        return true;
    }

}
