package com.ejet.bss.userflow.model;

import com.ejet.comm.base.CoBaseVO;
public class BssFlowApproveDetailModel extends CoBaseVO { 

	/**    */ 
 	private Integer id;
	/**  业务类型  */ 
 	private String bussType;
	/**  业务UUID  */ 
 	private String bussUuid;
	/**  业务数据记录UUID  */ 
 	private String bussRecordUuid;
	/**  流程ID  */ 
 	private Integer flowId;
	/**  节点ID  */ 
 	private Integer nodeId;
	/**  申请人  */ 
 	private String fromUser;
	/**  申请账号  */ 
 	private String fromAccountUuid;
	/**  审批人  */ 
 	private String toUser;
	/**  审批人账号UUID  */ 
 	private String toAccountUuid;
	/**  审批语  */ 
 	private String approverComment;
	/**  审批结果, 1: 同意，0：拒绝  */ 
 	private Integer approverResult;
	/**  审批时间  */ 
 	private String approveTime;
	/**  审批状态, 1: 等待审批，2: 正在审批，3：审批完成  */ 
 	private Integer flowStatus;
	/**  状态, 1: 正常，0：禁用  */ 
 	private Integer status;
	/**  备注  */ 
 	private String remark;
	/**  预留字段  */ 
 	private String ext;

	public void setId(Integer id) {
		this.id=id;
	} 

	public Integer getId(){
		return id;
	}

	public void setBussType(String bussType) {
		this.bussType=bussType;
	} 

	public String getBussType(){
		return bussType;
	}

	public void setBussUuid(String bussUuid) {
		this.bussUuid=bussUuid;
	} 

	public String getBussUuid(){
		return bussUuid;
	}

	public void setBussRecordUuid(String bussRecordUuid) {
		this.bussRecordUuid=bussRecordUuid;
	} 

	public String getBussRecordUuid(){
		return bussRecordUuid;
	}

	public void setFlowId(Integer flowId) {
		this.flowId=flowId;
	} 

	public Integer getFlowId(){
		return flowId;
	}

	public void setNodeId(Integer nodeId) {
		this.nodeId=nodeId;
	} 

	public Integer getNodeId(){
		return nodeId;
	}

	public void setFromUser(String fromUser) {
		this.fromUser=fromUser;
	} 

	public String getFromUser(){
		return fromUser;
	}

	public void setFromAccountUuid(String fromAccountUuid) {
		this.fromAccountUuid=fromAccountUuid;
	} 

	public String getFromAccountUuid(){
		return fromAccountUuid;
	}

	public void setToUser(String toUser) {
		this.toUser=toUser;
	} 

	public String getToUser(){
		return toUser;
	}

	public void setToAccountUuid(String toAccountUuid) {
		this.toAccountUuid=toAccountUuid;
	} 

	public String getToAccountUuid(){
		return toAccountUuid;
	}

	public void setApproverComment(String approverComment) {
		this.approverComment=approverComment;
	} 

	public String getApproverComment(){
		return approverComment;
	}

	public void setApproverResult(Integer approverResult) {
		this.approverResult=approverResult;
	} 

	public Integer getApproverResult(){
		return approverResult;
	}

	public void setApproveTime(String approveTime) {
		this.approveTime=approveTime;
	} 

	public String getApproveTime(){
		return approveTime;
	}

	public void setFlowStatus(Integer flowStatus) {
		this.flowStatus=flowStatus;
	} 

	public Integer getFlowStatus(){
		return flowStatus;
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


}