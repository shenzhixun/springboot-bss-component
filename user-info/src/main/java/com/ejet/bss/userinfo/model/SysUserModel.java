package com.ejet.bss.userinfo.model;

import com.ejet.comm.base.CoBaseVO;
public class SysUserModel extends CoBaseVO { 

	/**    */ 
 	private Integer id;
	/**  用户id  */ 
 	private Long userId;
	/**  用户名  */ 
 	private String userName;
	/**  姓名  */ 
 	private String fullname;
	/**  组织架构ID  */ 
 	private Integer orgzId;
	/**  个人头像  */ 
 	private String userPhoto;
	/**  电话号码  */ 
 	private String phone;
	/**  身份证号  */ 
 	private String idcard;
	/**  邮箱  */ 
 	private String email;
	/**  状态, 1: 分配账号，0：不分配  */ 
 	private Integer hasAccount;
	/**  帐号uuid  */ 
 	private String accountUuid;
	/**  用户状态, 1: 正常，0：禁用  */ 
 	private Integer status;
	/**  备注,描述  */ 
 	private String remark;
	/**  修改时间  */ 
 	private String modifyTime;
	/**  修改人  */ 
 	private String modifyUser;
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

	public void setUserName(String userName) {
		this.userName=userName;
	} 

	public String getUserName(){
		return userName;
	}

	public void setFullname(String fullname) {
		this.fullname=fullname;
	} 

	public String getFullname(){
		return fullname;
	}

	public void setOrgzId(Integer orgzId) {
		this.orgzId=orgzId;
	} 

	public Integer getOrgzId(){
		return orgzId;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto=userPhoto;
	} 

	public String getUserPhoto(){
		return userPhoto;
	}

	public void setPhone(String phone) {
		this.phone=phone;
	} 

	public String getPhone(){
		return phone;
	}

	public void setIdcard(String idcard) {
		this.idcard=idcard;
	} 

	public String getIdcard(){
		return idcard;
	}

	public void setEmail(String email) {
		this.email=email;
	} 

	public String getEmail(){
		return email;
	}

	public void setHasAccount(Integer hasAccount) {
		this.hasAccount=hasAccount;
	} 

	public Integer getHasAccount(){
		return hasAccount;
	}

	public void setAccountUuid(String accountUuid) {
		this.accountUuid=accountUuid;
	} 

	public String getAccountUuid(){
		return accountUuid;
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


}