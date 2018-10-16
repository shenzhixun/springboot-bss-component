package com.ejet.bss.userflow.model;

import com.ejet.comm.base.CoBaseVO;
public class BssFlowNodeModel extends CoBaseVO { 

	/**    */ 
 	private Integer id;
	/**  节点ID  */ 
 	private Integer nodeId;
	/**  流程ID  */ 
 	private Integer flowId;
	/**  节点名称  */ 
 	private String nodeName;
	/**  节点类型  */ 
 	private String nodeType;
	/**  节点步骤  */ 
 	private Integer nodeStep;
	/**  节点描述  */ 
 	private String nodeDes;
	/**  审批人类别， 1：主管-指定一级 2：主管-连续多级 3：指定成员 4：角色（一组固定成员）5：发起人自己  */ 
 	private Integer approverPersonType;
	/**  审批方式 ， 1:依次审批（本环节内审批人依次审批）2:会签（须所有审批人同意）,3:或签（一名审批人同意或拒绝即可）4:发起人从角色成员自选，   */ 
 	private Integer approveMode;
	/**  审批深度：只对直到第几级主管  */ 
 	private Integer approveDepth;
	/**  0: 不查找上级, 1:若该审批人空缺，由其在通讯录中的上级主管代审批， 2：提示流程错误  */ 
 	private Integer approverFill;
	/**  启用时间  */ 
 	private String runtime;
	/**  状态, 1: 正常，0：禁用  */ 
 	private Integer status;
	/**  备注  */ 
 	private String remark;
	/**  预留字段  */ 
 	private String ext;
	/**   3：指定成员 4：指定角色（一组固定成员）对应信息  */ 
 	private String approverUsers;

	public void setId(Integer id) {
		this.id=id;
	} 

	public Integer getId(){
		return id;
	}

	public void setNodeId(Integer nodeId) {
		this.nodeId=nodeId;
	} 

	public Integer getNodeId(){
		return nodeId;
	}

	public void setFlowId(Integer flowId) {
		this.flowId=flowId;
	} 

	public Integer getFlowId(){
		return flowId;
	}

	public void setNodeName(String nodeName) {
		this.nodeName=nodeName;
	} 

	public String getNodeName(){
		return nodeName;
	}

	public void setNodeType(String nodeType) {
		this.nodeType=nodeType;
	} 

	public String getNodeType(){
		return nodeType;
	}

	public void setNodeStep(Integer nodeStep) {
		this.nodeStep=nodeStep;
	} 

	public Integer getNodeStep(){
		return nodeStep;
	}

	public void setNodeDes(String nodeDes) {
		this.nodeDes=nodeDes;
	} 

	public String getNodeDes(){
		return nodeDes;
	}

	public void setApproverPersonType(Integer approverPersonType) {
		this.approverPersonType=approverPersonType;
	} 

	public Integer getApproverPersonType(){
		return approverPersonType;
	}

	public void setApproveMode(Integer approveMode) {
		this.approveMode=approveMode;
	} 

	public Integer getApproveMode(){
		return approveMode;
	}

	public void setApproveDepth(Integer approveDepth) {
		this.approveDepth=approveDepth;
	} 

	public Integer getApproveDepth(){
		return approveDepth;
	}

	public void setApproverFill(Integer approverFill) {
		this.approverFill=approverFill;
	} 

	public Integer getApproverFill(){
		return approverFill;
	}

	public void setRuntime(String runtime) {
		this.runtime=runtime;
	} 

	public String getRuntime(){
		return runtime;
	}

	public void setStatus(Integer status) {
		this.status=status;
	} 

	public Integer getStatus(){
		return status;
	}

	public void setRemark(String remark) {
		this.remark=remark;
	} 

	public String getRemark(){
		return remark;
	}

	public void setExt(String ext) {
		this.ext=ext;
	} 

	public String getExt(){
		return ext;
	}

	public void setApproverUsers(String approverUsers) {
		this.approverUsers=approverUsers;
	} 

	public String getApproverUsers(){
		return approverUsers;
	}


}