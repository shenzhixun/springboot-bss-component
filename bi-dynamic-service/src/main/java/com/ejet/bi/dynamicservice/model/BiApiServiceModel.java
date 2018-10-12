package com.ejet.bi.dynamicservice.model;

import com.ejet.comm.base.CoBaseVO;
public class BiApiServiceModel extends CoBaseVO { 

	/**    */ 
 	private Integer id;
	/**  标识ID  */ 
 	private String uuid;
	/**  分类UUID  */ 
 	private String apiCategoryUuid;
	/**  服务名称  */ 
 	private String name;
	/**  定义请求的路径  */ 
 	private String path;
	/**  参数名称  */ 
 	private String url;
	/**  url前缀信息  */ 
 	private String prefix;
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

	public void setApiCategoryUuid(String apiCategoryUuid) {
		this.apiCategoryUuid=apiCategoryUuid;
	} 

	public String getApiCategoryUuid(){
		return apiCategoryUuid;
	}

	public void setName(String name) {
		this.name=name;
	} 

	public String getName(){
		return name;
	}

	public void setPath(String path) {
		this.path=path;
	} 

	public String getPath(){
		return path;
	}

	public void setUrl(String url) {
		this.url=url;
	} 

	public String getUrl(){
		return url;
	}

	public void setPrefix(String prefix) {
		this.prefix=prefix;
	} 

	public String getPrefix(){
		return prefix;
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