package com.ejet.bss.userrights.model;

import com.ejet.comm.base.CoBaseVO;
public class SysAccountSyslevelRModel extends CoBaseVO { 

	/**    */ 
 	private Integer id;
	/**  用户ID  */ 
 	private Long userId;
	/**  体系ID  */ 
 	private Integer syslevelId;
	/**  体系类型  */ 
 	private Integer syslevelType;
	/**  体系层级  */ 
 	private Integer levels;
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

	public void setUserId(Long userId) {
		this.userId=userId;
	} 

	public Long getUserId(){
		return userId;
	}

	public void setSyslevelId(Integer syslevelId) {
		this.syslevelId=syslevelId;
	} 

	public Integer getSyslevelId(){
		return syslevelId;
	}

	public void setSyslevelType(Integer syslevelType) {
		this.syslevelType=syslevelType;
	} 

	public Integer getSyslevelType(){
		return syslevelType;
	}

	public void setLevels(Integer levels) {
		this.levels=levels;
	} 

	public Integer getLevels(){
		return levels;
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