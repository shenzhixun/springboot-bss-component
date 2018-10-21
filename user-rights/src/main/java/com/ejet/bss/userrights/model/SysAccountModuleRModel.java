package com.ejet.bss.userrights.model;

import com.ejet.comm.base.CoBaseVO;
public class SysAccountModuleRModel extends CoBaseVO { 

	/**    */ 
 	private Integer id;
	/**  帐号uuid  */ 
 	private String accountUuid;
	/**  模块ID  */ 
 	private Integer moduleId;
	/**  模块类型  */ 
 	private Integer moduleType;
	/**  模块对应权限：共五位：增，删，改，查，审批  1表示有，0表示无  */ 
 	private String actRights;
	/**  状态, 1: 正常，0：不正常  */ 
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

	public void setAccountUuid(String accountUuid) {
		this.accountUuid=accountUuid;
	} 

	public String getAccountUuid(){
		return accountUuid;
	}

	public void setModuleId(Integer moduleId) {
		this.moduleId=moduleId;
	} 

	public Integer getModuleId(){
		return moduleId;
	}

	public void setModuleType(Integer moduleType) {
		this.moduleType=moduleType;
	} 

	public Integer getModuleType(){
		return moduleType;
	}

	public void setActRights(String actRights) {
		this.actRights=actRights;
	} 

	public String getActRights(){
		return actRights;
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