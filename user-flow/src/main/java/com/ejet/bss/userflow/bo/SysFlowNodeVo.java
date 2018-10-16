package com.ejet.bss.userflow.bo;

import java.util.ArrayList;
import java.util.List;

import com.ejet.bss.userflow.model.BssFlowNodeModel;
import com.ejet.bss.userrights.model.SysAccountRoleRModel;

/**
 * 审批节点
 * 
 * @author ShenYijie
 *
 */
public class SysFlowNodeVo extends BssFlowNodeModel {
	
	/**
	 * 节点审批人
	 */
	List<SysAccountRoleRModel> approveUsers = new ArrayList<>();

	public List<SysAccountRoleRModel> getApproveUsers() {
		return approveUsers;
	}

	public void setApproveUsers(List<SysAccountRoleRModel> approveUsers) {
		this.approveUsers = approveUsers;
	}
	
	
	
}
