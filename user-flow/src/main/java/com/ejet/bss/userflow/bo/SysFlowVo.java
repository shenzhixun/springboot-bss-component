package com.ejet.bss.userflow.bo;

import java.util.List;

import com.ejet.bss.userflow.model.BssFlowModel;
import com.ejet.bss.userrights.model.SysAccountRoleRModel;

/**
 * 流程条件及流程
 * 
 * @author ShenYijie
 *
 */
public class SysFlowVo {
	/**
	 * 流程信息
	 */
	private BssFlowModel flow;
	/**
	 * 流程节点
	 */
	private List<SysFlowNodeVo> flowNodes;
	/**
	 * 	抄送类型
	 */
	private Integer ccType;
	/**
	 * 	抄送人或者角色
	 */
	private List<SysAccountRoleRModel> ccUsers;

	public BssFlowModel getFlow() {
		return flow;
	}

	public void setFlow(BssFlowModel flow) {
		this.flow = flow;
	}


	public List<SysFlowNodeVo> getFlowNodes() {
		return flowNodes;
	}

	public void setFlowNodes(List<SysFlowNodeVo> flowNodes) {
		this.flowNodes = flowNodes;
	}

	public Integer getCcType() {
		return ccType;
	}

	public void setCcType(Integer ccType) {
		this.ccType = ccType;
	}

	public List<SysAccountRoleRModel> getCcUsers() {
		return ccUsers;
	}

	public void setCcUsers(List<SysAccountRoleRModel> ccUsers) {
		this.ccUsers = ccUsers;
	}
	
	
	

}
