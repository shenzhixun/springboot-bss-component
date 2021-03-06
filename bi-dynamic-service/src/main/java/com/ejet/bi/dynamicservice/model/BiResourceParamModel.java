package com.ejet.bi.dynamicservice.model;

import com.ejet.comm.base.CoBaseVO;
public class BiResourceParamModel extends CoBaseVO { 

	/**    */ 
 	private Integer id;
	/**  sql标识ID  */ 
 	private String uuid;
	/**  业务bi_resource表uuid  */ 
 	private String resourceUuid;
	/**  参数名称  */ 
 	private String paramName;
	/**  参数类型  */ 
 	private String paramType;
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
	/**  参数值  */ 
 	private String paramValue;

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

	public void setResourceUuid(String resourceUuid) {
		this.resourceUuid=resourceUuid;
	} 

	public String getResourceUuid(){
		return resourceUuid;
	}

	public void setParamName(String paramName) {
		this.paramName=paramName;
	} 

	public String getParamName(){
		return paramName;
	}

	public void setParamType(String paramType) {
		this.paramType=paramType;
	} 

	public String getParamType(){
		return paramType;
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

	public void setParamValue(String paramValue) {
		this.paramValue=paramValue;
	} 

	public String getParamValue(){
		return paramValue;
	}


}