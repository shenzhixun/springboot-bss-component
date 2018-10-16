package com.ejet.bss.userflow.model;

import com.ejet.comm.base.CoBaseVO;
public class BssFlowBussRModel extends CoBaseVO { 

	/**    */ 
 	private Integer id;
	/**  业务类型  */ 
 	private String bussType;
	/**  业务UUID  */ 
 	private String bussUuid;
	/**  表单前置条件ID  */ 
 	private Integer bussConditionId;
	/**  流程ID  */ 
 	private Integer flowId;
	/**  流程编码  */ 
 	private String flowCode;
	/**  优先级， 0：表示默认流程 1:定义流程  */ 
 	private Integer priority;
	/**  有效期限开始时间  */ 
 	private String effectStart;
	/**  有效期限结束时间  */ 
 	private String effectEnd;
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

	public void setBussConditionId(Integer bussConditionId) {
		this.bussConditionId=bussConditionId;
	} 

	public Integer getBussConditionId(){
		return bussConditionId;
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

	public void setPriority(Integer priority) {
		this.priority=priority;
	} 

	public Integer getPriority(){
		return priority;
	}

	public void setEffectStart(String effectStart) {
		this.effectStart=effectStart;
	} 

	public String getEffectStart(){
		return effectStart;
	}

	public void setEffectEnd(String effectEnd) {
		this.effectEnd=effectEnd;
	} 

	public String getEffectEnd(){
		return effectEnd;
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