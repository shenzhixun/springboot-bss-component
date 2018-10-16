package com.ejet.bss.userflow.model;

import com.ejet.comm.base.CoBaseVO;
public class BssFlowApproveModel extends CoBaseVO { 

	/**    */ 
 	private Integer id;
	/**  业务类型  */ 
 	private String bussType;
	/**  业务UUID  */ 
 	private String bussUuid;
	/**  流程ID  */ 
 	private Integer flowId;
	/**  节点ID  */ 
 	private Integer nodeId;
	/**  节点名称  */ 
 	private String nodeName;
	/**  节点描述  */ 
 	private String nodeDes;
	/**  审批人  */ 
 	private Integer approverUser;
	/**  审批人UUID  */ 
 	private String approverUuid;
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

	public void setNodeName(String nodeName) {
		this.nodeName=nodeName;
	} 

	public String getNodeName(){
		return nodeName;
	}

	public void setNodeDes(String nodeDes) {
		this.nodeDes=nodeDes;
	} 

	public String getNodeDes(){
		return nodeDes;
	}

	public void setApproverUser(Integer approverUser) {
		this.approverUser=approverUser;
	} 

	public Integer getApproverUser(){
		return approverUser;
	}

	public void setApproverUuid(String approverUuid) {
		this.approverUuid=approverUuid;
	} 

	public String getApproverUuid(){
		return approverUuid;
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