package com.ejet.bss.userflow.service.impl;


import com.ejet.bss.userflow.bo.SysFlowNodeVo;
import com.ejet.bss.userflow.comm.ExceptionCode;
import com.ejet.bss.userflow.model.BssFlowBussRModel;
import com.ejet.bss.userflow.vo.BssFlowVO;
import com.ejet.comm.base.CoBaseVO;
import com.ejet.comm.utils.CheckUtils;
import com.ejet.comm.utils.StringUtils;
import com.ejet.comm.utils.reflect.ReflectUtils;
import com.ejet.global.CoConstant;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import com.ejet.comm.PageBean;
import com.github.pagehelper.PageHelper;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bss.userflow.model.BssFlowModel;
import com.ejet.bss.userflow.mapper.BssFlowDao;
import com.ejet.bss.userflow.service.IBssFlowService;
@Service("bssFlowService")
public class BssFlowServiceImpl implements IBssFlowService { 

	private final Logger log = LoggerFactory.getLogger(BssFlowServiceImpl.class);

	@Autowired
	private BssFlowDao mDao;
    @Autowired
    private BssFlowBussRServiceImpl flowBussRService;
    @Autowired
    private BssFlowNodeServiceImpl flowNodeService;

	@Override
	public void insertAutoKey(BssFlowModel model) throws CoBusinessException { 
 		mDao.insertAutoKey(model);
 	}  

	@Override
	public void update(BssFlowModel model) throws CoBusinessException { 
 		if(model.getId()==null) { 
 			throw new CoBusinessException(ExceptionCode.PARAM_MISSING_ID);
 		}
 		mDao.update(model);
 	}  

	@Override
	public void delete(BssFlowModel model) throws CoBusinessException { 
 		mDao.delete(model);
 	}  

	public BssFlowModel  findByPK(BssFlowModel model) throws CoBusinessException { 
 		return mDao.findByPK(model);
 	}

	@Override
	public List<BssFlowModel>  queryByCond(BssFlowModel model) throws CoBusinessException { 
 		return mDao.queryByCond(model);
 	}

	public PageBean<BssFlowModel> queryByPage(BssFlowModel model, Integer pageNum, Integer pageSize) throws CoBusinessException {
		PageHelper.startPage(pageNum, pageSize);
		List<BssFlowModel> list = mDao.queryByPage(model);
		PageBean<BssFlowModel> page = new PageBean<BssFlowModel>(list);
 		return page;
 	}

	public int insertSingle(BssFlowModel model) throws CoBusinessException { 
 		// 获取最大id。保证连续性
 		Integer maxId = mDao.findMaxId(null);
 		maxId = maxId==null? 1 : maxId+1;
 		model.setId(maxId);
 		mDao.insertSingle(model);
 		return maxId;
 	}

    public void checkFlow(BssFlowVO flow) throws CoBusinessException {
        //首先入库流程信息
        if(flow==null || StringUtil.isEmpty(flow.getBussUuid())
                || StringUtil.isEmpty(flow.getBussType())) {
            throw new CoBusinessException(ExceptionCode.FLOW_ADD_FORM_EMPTY); //表单ID、类型为空
        }
        if(StringUtils.isEmpty(flow.getFlowName())) {
            throw new CoBusinessException(ExceptionCode.FLOW_ADD_FLOW_NAME_EMPTY);
        }
        if(flow.getPriority()==null) {
            throw new CoBusinessException(ExceptionCode.FLOW_ADD_FLOW_PRIORITY_EMPTY);
        }
        if(flow.getFlowNodes()==null || flow.getFlowNodes().size()==0) {
            throw new CoBusinessException(ExceptionCode.FLOW_ADD_FLOW_NODES_EMPTY);
        }
        //如果默认流程
        if(flow.getPriority().intValue()==0) {

        }
        //忽略监测的字段
        List<String> ignoreFileds =  ReflectUtils.getDeclaredFieldsName(CoBaseVO.class);
        ignoreFileds.add("ccType");
        ignoreFileds.add("ccUsers");
        ignoreFileds.add("conditions");
        CheckUtils.checkObject(flow, ignoreFileds);

        List<String> ignoreFlowFileds = new ArrayList<>();
        ignoreFlowFileds.addAll(ignoreFileds);
        ignoreFlowFileds.add("id");
        ignoreFlowFileds.add("flowId");
        ignoreFlowFileds.add("flowCode");
        ignoreFlowFileds.add("flowVersion");
        ignoreFlowFileds.add("fullname");
        ignoreFlowFileds.add("ccType");
        ignoreFlowFileds.add("ccUsers");
        ignoreFlowFileds.add("runtime");
        ignoreFlowFileds.add("remark");
        ignoreFlowFileds.add("ext");
        CheckUtils.checkObject(flow, ignoreFlowFileds);

    }

    /**
     * 新增流程
     * @param flowVO
     * @throws CoBusinessException
     */
    public void addFlow(BssFlowVO flowVO) throws CoBusinessException {
        checkFlow(flowVO);

        //入库流程
        insertSingle(flowVO);

        //得到流程id，入库表单流程表单关联
        BssFlowBussRModel flowBussR = new BssFlowBussRModel();
        flowBussR.setFlowId(flowVO.getFlowId());
        flowBussR.setBussUuid(flowVO.getBussUuid());
        flowBussR.setBussType(flowVO.getBussType());
        flowBussR.setStatus(CoConstant.STATUS_NORMAL);
        flowBussRService.insertSingle(flowBussR);

        //入库表单前置条件表
        // flowVo.setFlow(flowModel);
        // formConnditionService.savePrecondition(flowVo, vo.getBussUuid());

        //流程节点表
        List<SysFlowNodeVo> nodes = flowVO.getFlowNodes();
        for(SysFlowNodeVo nodeVo: nodes) {
            flowNodeService.insertSingle(nodeVo);
        }





    }









}