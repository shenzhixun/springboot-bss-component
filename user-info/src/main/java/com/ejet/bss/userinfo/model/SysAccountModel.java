package com.ejet.bss.userinfo.model;

import com.ejet.comm.base.CoBaseVO;
public class SysAccountModel extends CoBaseVO { 

	/**    */ 
 	private Integer id;
	/**  帐号uuid  */ 
 	private String uuid;
	/**  登录名  */ 
 	private String name;
	/**  昵称  */ 
 	private String nickname;
	/**  密码  */ 
 	private String password;
	/**  账号类型 0：super管理员   1：管理员 2：普通用户  */ 
 	private Integer accountType;
	/**  账号状态 1:为启用   0:停用  */ 
 	private Integer accountState;
	/**  有效期限开始时间  */ 
 	private String effectStart;
	/**  有效期限结束时间  */ 
 	private String effectEnd;
	/**  最后登录时间  */ 
 	private String lastLogin;
	/**  登录状态, 1: 在线，0：未登录  */ 
 	private Integer loginState;
	/**  状态, 1: 正常，0：禁用  */ 
 	private Integer status;
	/**  备注,描述  */ 
 	private String remark;
	/**  创建时间  */ 
 	private String createTime;
	/**  修改时间  */ 
 	private String modifyTime;
	/**  修改人  */ 
 	private String modifyUser;
	/**  预留字段  */ 
 	private String ext;
	/**  预留字段  */ 
 	private String ext1;
	/**  预留字段  */ 
 	private String ext2;

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

	public void setName(String name) {
		this.name=name;
	} 

	public String getName(){
		return name;
	}

	public void setNickname(String nickname) {
		this.nickname=nickname;
	} 

	public String getNickname(){
		return nickname;
	}

	public void setPassword(String password) {
		this.password=password;
	} 

	public String getPassword(){
		return password;
	}

	public void setAccountType(Integer accountType) {
		this.accountType=accountType;
	} 

	public Integer getAccountType(){
		return accountType;
	}

	public void setAccountState(Integer accountState) {
		this.accountState=accountState;
	} 

	public Integer getAccountState(){
		return accountState;
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

	public void setLastLogin(String lastLogin) {
		this.lastLogin=lastLogin;
	} 

	public String getLastLogin(){
		return lastLogin;
	}

	public void setLoginState(Integer loginState) {
		this.loginState=loginState;
	} 

	public Integer getLoginState(){
		return loginState;
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

	public void setCreateTime(String createTime) {
		this.createTime=createTime;
	} 

	public String getCreateTime(){
		return createTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime=modifyTime;
	} 

	public String getModifyTime(){
		return modifyTime;
	}

	public void setModifyUser(String modifyUser) {
		this.modifyUser=modifyUser;
	} 

	public String getModifyUser(){
		return modifyUser;
	}

	public void setExt(String ext) {
		this.ext=ext;
	} 

	public String getExt(){
		return ext;
	}

	public void setExt1(String ext1) {
		this.ext1=ext1;
	} 

	public String getExt1(){
		return ext1;
	}

	public void setExt2(String ext2) {
		this.ext2=ext2;
	} 

	public String getExt2(){
		return ext2;
	}


}