package com.ejet.bss.userrights.model;

import com.ejet.comm.base.CoBaseVO;
public class SysOrgzModel extends CoBaseVO { 

	/**    */ 
 	private Integer id;
	/**  标识uuid  */ 
 	private String uuid;
	/**  组织机构Id  */ 
 	private Integer orgzId;
	/**  组织机构父Id  */ 
 	private Integer orgzPid;
	/**  组织机构编码  */ 
 	private String orgzCode;
	/**  名称  */ 
 	private String orgzName;
	/**  全称  */ 
 	private String fullname;
	/**  层级  */ 
 	private Integer orgzLevel;
	/**  层级  */ 
 	private Integer sortOrder;
	/**  搜索tag  */ 
 	private String searchTag;
    /**  模块状态, 1: 正常显示，0：不显示  */
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

	public void setOrgzId(Integer orgzId) {
		this.orgzId=orgzId;
	} 

	public Integer getOrgzId(){
		return orgzId;
	}

	public void setOrgzPid(Integer orgzPid) {
		this.orgzPid=orgzPid;
	} 

	public Integer getOrgzPid(){
		return orgzPid;
	}

	public void setOrgzCode(String orgzCode) {
		this.orgzCode=orgzCode;
	} 

	public String getOrgzCode(){
		return orgzCode;
	}

	public void setOrgzName(String orgzName) {
		this.orgzName=orgzName;
	} 

	public String getOrgzName(){
		return orgzName;
	}

	public void setFullname(String fullname) {
		this.fullname=fullname;
	} 

	public String getFullname(){
		return fullname;
	}

	public void setOrgzLevel(Integer orgzLevel) {
		this.orgzLevel=orgzLevel;
	} 

	public Integer getOrgzLevel(){
		return orgzLevel;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder=sortOrder;
	} 

	public Integer getSortOrder(){
		return sortOrder;
	}

	public void setSearchTag(String searchTag) {
		this.searchTag=searchTag;
	} 

	public String getSearchTag(){
		return searchTag;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}