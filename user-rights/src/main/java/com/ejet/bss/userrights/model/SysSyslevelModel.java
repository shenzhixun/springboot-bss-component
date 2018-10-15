package com.ejet.bss.userrights.model;

import com.ejet.comm.base.CoBaseVO;
public class SysSyslevelModel extends CoBaseVO { 

	/**    */ 
 	private Integer id;
	/**  节点编号  */ 
 	private Integer syslevelId;
	/**  节点名  */ 
 	private String syslevelName;
	/**  父节点编号  */ 
 	private Integer syslevelPid;
	/**  节点层级  */ 
 	private Integer levels;
	/**  节点类型：1、组织架构 2：行政区域（预留）  */ 
 	private Integer syslevelType;
	/**  状态, 1: 正常，0：不正常  */ 
 	private Integer status;
	/**  备注  */ 
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

	public void setSyslevelId(Integer syslevelId) {
		this.syslevelId=syslevelId;
	} 

	public Integer getSyslevelId(){
		return syslevelId;
	}

	public void setSyslevelName(String syslevelName) {
		this.syslevelName=syslevelName;
	} 

	public String getSyslevelName(){
		return syslevelName;
	}

	public void setSyslevelPid(Integer syslevelPid) {
		this.syslevelPid=syslevelPid;
	} 

	public Integer getSyslevelPid(){
		return syslevelPid;
	}

	public void setLevels(Integer levels) {
		this.levels=levels;
	} 

	public Integer getLevels(){
		return levels;
	}

	public void setSyslevelType(Integer syslevelType) {
		this.syslevelType=syslevelType;
	} 

	public Integer getSyslevelType(){
		return syslevelType;
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