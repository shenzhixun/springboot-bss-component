package com.ejet.bss.userrights.model;

import com.ejet.comm.base.CoBaseVO;
public class SysRoleSyslevelRModel extends CoBaseVO { 

	/**    */ 
 	private Integer id;
	/**  角色ID  */ 
 	private Integer roleId;
	/**  体系ID  */ 
 	private Integer syslevelId;
	/**  体系类型  */ 
 	private Integer syslevelType;
	/**  体系层级  */ 
 	private Integer levels;
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

	public void setRoleId(Integer roleId) {
		this.roleId=roleId;
	} 

	public Integer getRoleId(){
		return roleId;
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