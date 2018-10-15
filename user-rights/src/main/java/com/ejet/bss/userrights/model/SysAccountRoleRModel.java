package com.ejet.bss.userrights.model;

import com.ejet.comm.base.CoBaseVO;
public class SysAccountRoleRModel extends CoBaseVO { 

	/**    */ 
 	private Integer id;
	/**  用户id  */ 
 	private Long userId;
	/**  角色ID  */ 
 	private Integer roleId;
	/**  角色类型ID  */ 
 	private Integer roleTypeId;
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

	public void setRoleId(Integer roleId) {
		this.roleId=roleId;
	} 

	public Integer getRoleId(){
		return roleId;
	}

	public void setRoleTypeId(Integer roleTypeId) {
		this.roleTypeId=roleTypeId;
	} 

	public Integer getRoleTypeId(){
		return roleTypeId;
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