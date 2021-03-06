package com.ejet.bss.userflow.service.impl;


import com.ejet.bss.userflow.bo.BssApplyBO;
import com.ejet.bss.userflow.bo.BssFlowBO;
import com.ejet.bss.userflow.bo.BssFlowNodeBO;
import com.ejet.bss.userflow.bo.BssFlowRequestBO;
import com.ejet.bss.userflow.comm.ExceptionCodeFlow;
import com.ejet.bss.userflow.comm.FlowConstant;
import com.ejet.bss.userflow.mapper.BssFlowDao;
import com.ejet.bss.userflow.model.BssFlowBussRModel;
import com.ejet.bss.userflow.model.BssFlowModel;
import com.ejet.bss.userflow.model.BssFlowNodeModel;
import com.ejet.bss.userflow.service.IBssFlowService;
import com.ejet.comm.exception.ExceptionCode;
import com.ejet.comm.utils.StringUtils;
import com.ejet.comm.utils.time.TimeUtils;
import com.ejet.global.CoConstant;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import com.ejet.comm.PageBean;
import com.github.pagehelper.PageHelper;
import com.ejet.comm.exception.CoBusinessException;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("bssFlowService")
public class BssFlowServiceImpl implements IBssFlowService {

	private final Logger log = LoggerFactory.getLogger(BssFlowServiceImpl.class);

	@Autowired
	private BssFlowDao mDao;
    @Autowired
    private BssFlowBussRServiceImpl flowBussRService;
    @Autowired
    private BssFlowNodeServiceImpl flowNodeService;
    @Autowired
    private BssFlowApproveApplyServiceImpl approveApplyService;


    @Override
	public int insertAutoKey(BssFlowModel model) throws CoBusinessException {
 		return mDao.insertAutoKey(model);
 	}  

	@Override
	public void update(BssFlowModel model) throws CoBusinessException { 
 		if(model.getId()==null) { 
 			throw new CoBusinessException(ExceptionCodeFlow.PARAM_MISSING_ID);
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
 		model.setFlowId(maxId);
 		model.setStatus(model.getStatus()==null ? CoConstant.STATUS_NORMAL : model.getStatus());
 		mDao.insertSingle(model);
 		return maxId;
 	}

    public void checkFlow(BssFlowBO flowBO) throws CoBusinessException {

        if(flowBO==null || flowBO.getFlow()==null) {
            throw new CoBusinessException(ExceptionCodeFlow.FLOW_ADD_FLOW_NAME_EMPTY);
        }

        if(flowBO.getFlowNodes()==null || flowBO.getFlowNodes().size()==0) {
            throw new CoBusinessException(ExceptionCodeFlow.FLOW_ADD_FLOW_NODES_EMPTY);
        }

        BssFlowModel flowModel = flowBO.getFlow();
        if(StringUtils.isEmpty(flowModel.getFlowName())) {
            throw new CoBusinessException(ExceptionCodeFlow.FLOW_ADD_FLOW_NAME_EMPTY);
        }
        if(flowModel.getPriority()==null) {
            throw new CoBusinessException(ExceptionCodeFlow.FLOW_ADD_FLOW_PRIORITY_EMPTY);
        }

        //忽略监测的字段
        // List<String> ignoreFileds =  ReflectUtils.getDeclaredFieldsName(CoBaseVO.class);
        // ignoreFileds.add("ccType");
        // ignoreFileds.add("ccUsers");
        // ignoreFileds.add("conditions");
        // CheckUtils.checkObject(flowModel, ignoreFileds);
        //
        // List<String> ignoreFlowFileds = new ArrayList<>();
        // ignoreFlowFileds.addAll(ignoreFileds);
        // ignoreFlowFileds.add("id");
        // ignoreFlowFileds.add("flowId");
        // ignoreFlowFileds.add("flowCode");
        // ignoreFlowFileds.add("flowVersion");
        // ignoreFlowFileds.add("fullname");
        // ignoreFlowFileds.add("ccType");
        // ignoreFlowFileds.add("ccUsers");
        // ignoreFlowFileds.add("runtime");
        // ignoreFlowFileds.add("remark");
        // ignoreFlowFileds.add("ext");
        // CheckUtils.checkObject(flowModel, ignoreFlowFileds);

    }

    /**
     * 新增流程
     * @throws CoBusinessException
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT,
            timeout= FlowConstant.TRANSACTION_TIME_OUT, rollbackFor={Exception.class,CoBusinessException.class})
    public void addFlow(BssFlowRequestBO flowReqBO) throws CoBusinessException {

        if(flowReqBO==null || StringUtil.isEmpty(flowReqBO.getBussUuid())
                || StringUtil.isEmpty(flowReqBO.getBussType())) {
            throw new CoBusinessException(ExceptionCodeFlow.FLOW_ADD_FORM_EMPTY); //表单ID、类型为空
        }

        BssFlowBO flowBO = flowReqBO.getFlowBO();
        checkFlow(flowBO);

        //入库流程
        BssFlowModel flowModel = flowBO.getFlow();
        insertSingle(flowModel);

        //得到流程id，入库表单流程表单关联
        BssFlowBussRModel flowBussR = new BssFlowBussRModel();
        flowBussR.setBussUuid(flowReqBO.getBussUuid());
        flowBussR.setBussType(flowReqBO.getBussType());
        flowBussR.setFlowId(flowModel.getFlowId());
        flowBussR.setFlowCode(flowModel.getFlowCode());
        flowBussR.setStatus(CoConstant.STATUS_NORMAL);
        flowBussRService.insertSingle(flowBussR);

        //入库表单前置条件表
        // flowVo.setFlow(flowModel);
        // formConnditionService.savePrecondition(flowVo, vo.getBussUuid());

        //流程节点表
        List<BssFlowNodeBO> nodes = flowBO.getFlowNodes();
        for(BssFlowNodeBO nodeVo: nodes) {
            nodeVo.setFlowId(flowModel.getFlowId());
            flowNodeService.insertSingle(nodeVo);
        }

    }


    /**
     *  提交表单
     * @throws CoBusinessException
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT,
            timeout= FlowConstant.TRANSACTION_TIME_OUT, rollbackFor={Exception.class,CoBusinessException.class})
    public void applyBuss(BssApplyBO applyBO) throws CoBusinessException {
        //提交后，同时进行通知。
        if(applyBO.getBussUuid()==null || applyBO.getBussRecordUuid()==null
                || applyBO.getBussTitle()==null) {
            throw new CoBusinessException(ExceptionCode.PARAM_MISSING);
        }

        //查询表单对应流程id
        BssFlowBussRModel flowbussR = new BssFlowBussRModel();
        flowbussR.setBussUuid(applyBO.getBussUuid());
        flowbussR.setStatus(CoConstant.STATUS_NORMAL);
        //flowbussR.setEffectEndTime(TimeUtils.getCurrentTime());
        flowbussR.setOrderCond(" priority desc "); //降序
        List<BssFlowBussRModel> bussRList = flowBussRService.queryByCond(flowbussR);
        if(bussRList==null || bussRList.size()==0) {
            throw new CoBusinessException(ExceptionCodeFlow.FLOW_NOT_FOUND);
        }
        Integer flowId = bussRList.get(0).getFlowId();
        applyBO.setFlowId(flowId);

        applyBO.setFlowStatus(FlowConstant.FLOW_APPROVE_STATUS_START);  //开始
        applyBO.setApproverResult(FlowConstant.FLOW_APPROVE_RESULT_GOING); //审核中
        approveApplyService.insertSingle(applyBO);

        //通知审批者,查询流程节点信息
        BssFlowNodeModel nodeQuery = new BssFlowNodeModel();
        nodeQuery.setFlowId(flowId);
        nodeQuery.setStatus(CoConstant.STATUS_NORMAL);
        nodeQuery.setOrderCond(" node_step asc ");

        List<BssFlowNodeModel> nodeResult = flowNodeService.queryByCond(nodeQuery);
        if(nodeResult==null || nodeResult.size()==0) {
            throw new CoBusinessException(ExceptionCodeFlow.FLOW_ADD_FLOW_NODES_EMPTY);
        }
        System.out.println();




    }






}