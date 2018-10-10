package com.ejet.bi.dynamicservice.model;

import com.ejet.comm.base.CoBaseVO;
public class BiApiCategoryModel extends CoBaseVO { 

	/**    */ 
 	private Integer id;
	/**  分组标识ID  */ 
 	private String uuid;
	/**  分组名称  */ 
 	private String name;
	/**    */ 
 	private String urlPrefix;
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

	public void setUrlPrefix(String urlPrefix) {
		this.urlPrefix=urlPrefix;
	} 

	public String getUrlPrefix(){
		return urlPrefix;
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