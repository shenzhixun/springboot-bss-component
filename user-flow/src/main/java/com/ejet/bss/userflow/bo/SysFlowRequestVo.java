package com.ejet.bss.userflow.bo;

import java.util.List;

/**
 * 保存流程信息Vo
 * 
 * @author ShenYijie
 *
 */
public class SysFlowRequestVo {
		
	/** 表单ID */
	private String sysFormId;
	/** 表单类型 */
	private String sysFormType;
	/**
	 * 分支流程
	 */
	private List<SysFlowVo> batchFlows;
	
	public String getSysFormId() {
		return sysFormId;
	}
	public void setSysFormId(String sysFormId) {
		this.sysFormId = sysFormId;
	}
	public String getSysFormType() {
		return sysFormType;
	}
	public void setSysFormType(String sysFormType) {
		this.sysFormType = sysFormType;
	}
	public List<SysFlowVo> getBatchFlows() {
		return batchFlows;
	}
	public void setBatchFlows(List<SysFlowVo> batchFlows) {
		this.batchFlows = batchFlows;
	}
	
	

}
