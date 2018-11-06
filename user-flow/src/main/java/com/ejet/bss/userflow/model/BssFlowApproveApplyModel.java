package com.ejet.bss.userflow.model;

import com.ejet.comm.base.CoBaseVO;
public class BssFlowApproveApplyModel extends CoBaseVO { 

	/**    */ 
 	private Integer id;
	/**  UUID  */ 
 	private String uuid;
	/**  业务类型  */ 
 	private String bussType;
	/**  业务类型UUID  */ 
 	private String bussUuid;
	/**  业务表单UUID  */ 
 	private String bussRecordUuid;
	/**  业务表单通知标题  */ 
 	private String bussTitle;
	/**  流程ID  */ 
 	private Integer flowId;
	/**  流程名称  */ 
 	private String flowName;
	/**  提交时间  */ 
 	private String bussApplyTime;
	/**  申请人  */ 
 	private String fromUser;
	/**  申请账号  */ 
 	private String fromAccountUuid;
	/**  审批状态, 1: 等待审批，2: 正在审批，3：审批完成  */ 
 	private Integer flowStatus;
	/**  审批结果, 0: 审核中， 1: 同意，2：拒绝  */ 
 	private Integer approverResult;
	/**  审批开始时间  */ 
 	private String approveStartTime;
	/**  审批结束时间  */ 
 	private String approveEndTime;
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

	public void setUuid(String uuid) {
		this.uuid=uuid;
	} 

	public String getUuid(){
		return uuid;
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

	public void setBussTitle(String bussTitle) {
		this.bussTitle=bussTitle;
	} 

	public String getBussTitle(){
		return bussTitle;
	}

	public void setFlowId(Integer flowId) {
		this.flowId=flowId;
	} 

	public Integer getFlowId(){
		return flowId;
	}

	public void setFlowName(String flowName) {
		this.flowName=flowName;
	} 

	public String getFlowName(){
		return flowName;
	}

	public void setBussApplyTime(String bussApplyTime) {
		this.bussApplyTime=bussApplyTime;
	} 

	public String getBussApplyTime(){
		return bussApplyTime;
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

	public void setFlowStatus(Integer flowStatus) {
		this.flowStatus=flowStatus;
	} 

	public Integer getFlowStatus(){
		return flowStatus;
	}

	public void setApproverResult(Integer approverResult) {
		this.approverResult=approverResult;
	} 

	public Integer getApproverResult(){
		return approverResult;
	}

	public void setApproveStartTime(String approveStartTime) {
		this.approveStartTime=approveStartTime;
	} 

	public String getApproveStartTime(){
		return approveStartTime;
	}

	public void setApproveEndTime(String approveEndTime) {
		this.approveEndTime=approveEndTime;
	} 

	public String getApproveEndTime(){
		return approveEndTime;
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