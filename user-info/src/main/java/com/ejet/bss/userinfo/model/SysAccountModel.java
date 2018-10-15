package com.ejet.bss.userinfo.model;

import com.ejet.comm.base.CoBaseVO;
public class SysAccountModel extends CoBaseVO { 

	/**    */ 
 	private Integer id;
	/**  员工uuid  */ 
 	private String uuid;
	/**  用户id  */ 
 	private Long userId;
	/**  登录名  */ 
 	private String name;
	/**  姓名  */ 
 	private String fullname;
	/**  密码  */ 
 	private String password;
	/**  组织架构ID  */ 
 	private Integer orgzId;
	/**  账号类型 0：super管理员   1：普通用户  */ 
 	private Integer userType;
	/**  账号状态 1:为启用   0:停用  */ 
 	private Integer userState;
	/**  最后登录时间  */ 
 	private String lastLogin;
	/**  电话号码  */ 
 	private String phone;
	/**  身份证号  */ 
 	private String idcard;
	/**  邮箱  */ 
 	private String email;
	/**  个人头像  */ 
 	private String userPhoto;
	/**  有效期限开始时间  */ 
 	private String effectStart;
	/**  有效期限结束时间  */ 
 	private String effectEnd;
	/**  状态, 1: 正常，0：禁用  */ 
 	private Integer status;
	/**  备注,描述  */ 
 	private String remark;
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

	public void setUserId(Long userId) {
		this.userId=userId;
	} 

	public Long getUserId(){
		return userId;
	}

	public void setName(String name) {
		this.name=name;
	} 

	public String getName(){
		return name;
	}

	public void setFullname(String fullname) {
		this.fullname=fullname;
	} 

	public String getFullname(){
		return fullname;
	}

	public void setPassword(String password) {
		this.password=password;
	} 

	public String getPassword(){
		return password;
	}

	public void setOrgzId(Integer orgzId) {
		this.orgzId=orgzId;
	} 

	public Integer getOrgzId(){
		return orgzId;
	}

	public void setUserType(Integer userType) {
		this.userType=userType;
	} 

	public Integer getUserType(){
		return userType;
	}

	public void setUserState(Integer userState) {
		this.userState=userState;
	} 

	public Integer getUserState(){
		return userState;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin=lastLogin;
	} 

	public String getLastLogin(){
		return lastLogin;
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

	public void setUserPhoto(String userPhoto) {
		this.userPhoto=userPhoto;
	} 

	public String getUserPhoto(){
		return userPhoto;
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