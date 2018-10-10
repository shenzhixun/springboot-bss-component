package com.ejet.bi.dynamicservice.model;

import com.ejet.comm.base.CoBaseVO;
public class BiResourceModel extends CoBaseVO { 

	/**    */ 
 	private Integer id;
	/**  sql标识ID  */ 
 	private String uuid;
	/**  库名称  */ 
 	private String databaseInfoUuid;
	/**  分组标识ID  */ 
 	private String resourceCategoryUuid;
	/**  分组名称  */ 
 	private String resourceCategoryName;
	/**  sql业务名称  */ 
 	private String name;
	/**  viewprocsqlfunc  */ 
 	private String type;
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
	/**  视图sql内容  */ 
 	private String sqlContent;

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

	public void setDatabaseInfoUuid(String databaseInfoUuid) {
		this.databaseInfoUuid=databaseInfoUuid;
	} 

	public String getDatabaseInfoUuid(){
		return databaseInfoUuid;
	}

	public void setResourceCategoryUuid(String resourceCategoryUuid) {
		this.resourceCategoryUuid=resourceCategoryUuid;
	} 

	public String getResourceCategoryUuid(){
		return resourceCategoryUuid;
	}

	public void setResourceCategoryName(String resourceCategoryName) {
		this.resourceCategoryName=resourceCategoryName;
	} 

	public String getResourceCategoryName(){
		return resourceCategoryName;
	}

	public void setName(String name) {
		this.name=name;
	} 

	public String getName(){
		return name;
	}

	public void setType(String type) {
		this.type=type;
	} 

	public String getType(){
		return type;
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

	public void setSqlContent(String sqlContent) {
		this.sqlContent=sqlContent;
	} 

	public String getSqlContent(){
		return sqlContent;
	}


}