package com.ejet.bss.userflow.model;

import com.ejet.comm.base.CoBaseVO;
public class BssFlowModel extends CoBaseVO { 

	/**    */ 
 	private Integer id;
	/**  流程ID  */ 
 	private Integer flowId;
	/**  流程code  */ 
 	private String flowCode;
	/**  流程类型  */ 
 	private String flowType;
	/**  流程名称  */ 
 	private String flowName;
	/**  全名  */ 
 	private String fullname;
	/**  流程版本  */ 
 	private String flowVersion;
	/**  优先级， 0：表示默认流程 1:定义流程  */ 
 	private Integer priority;
	/**  抄送类型，0：无抄送人员，1：按角色，2：按人员  */ 
 	private Integer ccType;
	/**  启用时间  */ 
 	private String effectStartTime;
	/**  停用时间  */ 
 	private String effectEndTime;
	/**  状态, 1: 正常，0：禁用  */ 
 	private Integer status;
	/**  备注  */ 
 	private String remark;
	/**  预留字段  */ 
 	private String ext;
	/**  抄送人或者角色（人数最多不超过30个人）  */ 
 	private String ccUsers;

	public void setId(Integer id) {
		this.id=id;
	} 

	public Integer getId(){
		return id;
	}

	public void setFlowId(Integer flowId) {
		this.flowId=flowId;
	} 

	public Integer getFlowId(){
		return flowId;
	}

	public void setFlowCode(String flowCode) {
		this.flowCode=flowCode;
	} 

	public String getFlowCode(){
		return flowCode;
	}

	public void setFlowType(String flowType) {
		this.flowType=flowType;
	} 

	public String getFlowType(){
		return flowType;
	}

	public void setFlowName(String flowName) {
		this.flowName=flowName;
	} 

	public String getFlowName(){
		return flowName;
	}

	public void setFullname(String fullname) {
		this.fullname=fullname;
	} 

	public String getFullname(){
		return fullname;
	}

	public void setFlowVersion(String flowVersion) {
		this.flowVersion=flowVersion;
	} 

	public String getFlowVersion(){
		return flowVersion;
	}

	public void setPriority(Integer priority) {
		this.priority=priority;
	} 

	public Integer getPriority(){
		return priority;
	}

	public void setCcType(Integer ccType) {
		this.ccType=ccType;
	} 

	public Integer getCcType(){
		return ccType;
	}

	public void setEffectStartTime(String effectStartTime) {
		this.effectStartTime=effectStartTime;
	} 

	public String getEffectStartTime(){
		return effectStartTime;
	}

	public void setEffectEndTime(String effectEndTime) {
		this.effectEndTime=effectEndTime;
	} 

	public String getEffectEndTime(){
		return effectEndTime;
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

	public void setCcUsers(String ccUsers) {
		this.ccUsers=ccUsers;
	} 

	public String getCcUsers(){
		return ccUsers;
	}


}