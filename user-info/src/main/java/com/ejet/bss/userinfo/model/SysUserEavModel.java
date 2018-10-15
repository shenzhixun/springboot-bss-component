package com.ejet.bss.userinfo.model;

import com.ejet.comm.base.CoBaseVO;
public class SysUserEavModel extends CoBaseVO { 

	/**    */ 
 	private Integer id;
	/**  sys_account表中uuid  */ 
 	private String userUuid;
	/**  字段key  */ 
 	private String dictKey;
	/**  字段编码  */ 
 	private String dictCode;
	/**  字段值  */ 
 	private String dictValue;
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

	public void setId(Integer id) {
		this.id=id;
	} 

	public Integer getId(){
		return id;
	}

	public void setUserUuid(String userUuid) {
		this.userUuid=userUuid;
	} 

	public String getUserUuid(){
		return userUuid;
	}

	public void setDictKey(String dictKey) {
		this.dictKey=dictKey;
	} 

	public String getDictKey(){
		return dictKey;
	}

	public void setDictCode(String dictCode) {
		this.dictCode=dictCode;
	} 

	public String getDictCode(){
		return dictCode;
	}

	public void setDictValue(String dictValue) {
		this.dictValue=dictValue;
	} 

	public String getDictValue(){
		return dictValue;
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