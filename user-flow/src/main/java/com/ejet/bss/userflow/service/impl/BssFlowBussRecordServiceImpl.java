package com.ejet.bss.userflow.service.impl;

import java.sql.SQLException;

import com.ejet.bss.userflow.comm.constant.FlowApproverEm;
import com.ejet.global.CoConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;

import com.ejet.comm.exception.ExceptionCode;
import com.ejet.comm.PageBean;
import com.github.pagehelper.PageHelper;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.bss.userflow.model.BssFlowBussRecordModel;
import com.ejet.bss.userflow.mapper.BssFlowBussRecordDao;
import com.ejet.bss.userflow.service.IBssFlowBussRecordService;
@Service("bssFlowBussRecordService")
public class BssFlowBussRecordServiceImpl implements IBssFlowBussRecordService { 


	private final Logger log = LoggerFactory.getLogger(BssFlowBussRecordServiceImpl.class);

	@Autowired
	private BssFlowBussRecordDao mDao;

	@Override
	public void insertAutoKey(BssFlowBussRecordModel model) throws CoBusinessException { 
 		mDao.insertAutoKey(model);
 	}  

	@Override
	public void update(BssFlowBussRecordModel model) throws CoBusinessException { 
 		if(model.getId()==null) { 
 			throw new CoBusinessException(ExceptionCode.PARAM_MISSING_ID);
 		}
 		mDao.update(model);
 	}  

	@Override
	public void delete(BssFlowBussRecordModel model) throws CoBusinessException { 
 		mDao.delete(model);
 	}  

	public BssFlowBussRecordModel  findByPK(BssFlowBussRecordModel model) throws CoBusinessException { 
 		return mDao.findByPK(model);
 	}

	@Override
	public List<BssFlowBussRecordModel>  queryByCond(BssFlowBussRecordModel model) throws CoBusinessException { 
 		return mDao.queryByCond(model);
 	}

	public PageBean<BssFlowBussRecordModel>  queryByPage(BssFlowBussRecordModel model, Integer pageNum, Integer pageSize) throws CoBusinessException { 
		PageHelper.startPage(pageNum, pageSize);
		List<BssFlowBussRecordModel> list = mDao.queryByPage(model);
		PageBean<BssFlowBussRecordModel> page = new PageBean<BssFlowBussRecordModel>(list);
 		return page;
 	}

	public int insertSingle(BssFlowBussRecordModel model) throws CoBusinessException { 
 		// 获取最大id。保证连续性
 		Integer maxId = mDao.findMaxId(null);
 		maxId = maxId==null? 1 : maxId+1;
 		model.setId(maxId);
 		mDao.insertSingle(model);
 		return maxId;
 	}


    /**
     * 发起流程调用
     */
 	public void callFlowBuss() {
        log.info("====调用流程接口：{}", req);
        //查询流程信息
        SysFlowModel flowQuery = new SysFlowModel();
        flowQuery.setFlowId(req.getSysFlowId());
        SysFlowModel flow = flowService.findByFlowId(flowQuery);
        if(flow.getStatus()== CoConstant.FLOW_STATUS_OVER) { //如果此流程为3，表示不需要审批
            overFlow(req);
            return;
        }
        //根据流程查询所有节点
        SysFlowNodeModel nodeQuery = new SysFlowNodeModel();
        nodeQuery.setFlowId(req.getSysFlowId());
        List<SysFlowNodeModel> nodes = nodeService.queryByCond(nodeQuery);
        if(nodes==null || nodes.size()==0) {
            throw new CoBusinessException(CoReturnFormat.FLOW_ADD_FLOW_NODES_EMPTY);
        }

        //查询节点对应审批人信息。并按审批步骤排序
        Collections.sort(nodes, new Comparator<SysFlowNodeModel>() {
            @Override
            public int compare(SysFlowNodeModel o1, SysFlowNodeModel o2) {
                return o1.getNodeStep()-o2.getNodeStep();
            }
        });

        // 获取所有节点
        log.info("节点信息：{}", nodes);

        //初次，取第一个节点
        SysFlowNodeModel firstNode = nodes.get(0);
        //获取审批人类别
        Integer approverPersonType = firstNode.getApproverPersonType();
        if(FlowApproverEm.DIRECTOR_ONE.getValue() == approverPersonType) { //审批人为上级主管。
            //获取审批深度
            Integer depth = firstNode.getApproveDepth();
            //查找提交人的部门信息
            req.setRoleTypeCode(CoConstant.ROLE_TYPE_CODE_DEPT_MANAGER);//部门主管角色
            List<SysUserDeptVO> users = getDeptManager(req);
            notileAndInsertNodes(nodes, users, req);
        }
//		} else if(FlowApproverEm.DIRECTOR_MULTI.ordinal() == approverPersonType) { //连续多级
//			//获取审批深度
//			Integer depth = firstNode.getApproveDepth();
//			//查找提交人的部门信息
//			List<SysUserDeptVO> users = getDeptManager(req);
//			notileAndInsertNodes(users);
//
//		} else if(FlowApproverEm.DIRECTOR_USERS.ordinal() == approverPersonType) { //指定成员
//			//获取审批深度
//			Integer depth = firstNode.getApproveDepth();
//			//查找提交人的部门信息
//			List<SysUserDeptVO> users = getDeptManager(req);
//			notileAndInsertNodes(users);
        if(FlowApproverEm.DIRECTOR_ROLES.ordinal() == approverPersonType) { //角色
            //获取角色对应人员信息
            //List<SysUserModel> users = flow

        }
//		}else if(FlowApproverEm.DIRECTOR_SELF.ordinal() == approverPersonType) { //自己
//			//获取审批深度
//			Integer depth = firstNode.getApproveDepth();
//			//查找提交人的部门信息
//			List<SysUserDeptVO> users = getDeptManager(req);
//			notileAndInsertNodes(users);
//
//		}



    }


}