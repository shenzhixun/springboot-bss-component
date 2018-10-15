package com.ejet.bss.userrights.model;

import com.ejet.comm.base.CoBaseVO;
public class SysModuleModel extends CoBaseVO { 

	/**    */ 
 	private Integer id;
	/**  模块ID  */ 
 	private Integer moduleId;
	/**  父模块  */ 
 	private Integer modulePid;
	/**  层级  */ 
 	private Integer moduleLevel;
	/**  模块名称  */ 
 	private String moduleName;
	/**  模块名称(英文)  */ 
 	private String moduleNameEn;
	/**  模块类型,  1:菜单， 2：链接页面 ，3：button   */ 
 	private Integer moduleType;
	/**  排序  */ 
 	private Integer sortOrder;
	/**  模块URL  */ 
 	private String url;
	/**  动作  */ 
 	private String act;
	/**  标志(备用)  */ 
 	private String flag;
	/**  模块icon  */ 
 	private String icon;
	/**  模块css样式  */ 
 	private String css;
	/**  模块状态, 1: 正常显示，0：不显示  */ 
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

	public void setModuleId(Integer moduleId) {
		this.moduleId=moduleId;
	} 

	public Integer getModuleId(){
		return moduleId;
	}

	public void setModulePid(Integer modulePid) {
		this.modulePid=modulePid;
	} 

	public Integer getModulePid(){
		return modulePid;
	}

	public void setModuleLevel(Integer moduleLevel) {
		this.moduleLevel=moduleLevel;
	} 

	public Integer getModuleLevel(){
		return moduleLevel;
	}

	public void setModuleName(String moduleName) {
		this.moduleName=moduleName;
	} 

	public String getModuleName(){
		return moduleName;
	}

	public void setModuleNameEn(String moduleNameEn) {
		this.moduleNameEn=moduleNameEn;
	} 

	public String getModuleNameEn(){
		return moduleNameEn;
	}

	public void setModuleType(Integer moduleType) {
		this.moduleType=moduleType;
	} 

	public Integer getModuleType(){
		return moduleType;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder=sortOrder;
	} 

	public Integer getSortOrder(){
		return sortOrder;
	}

	public void setUrl(String url) {
		this.url=url;
	} 

	public String getUrl(){
		return url;
	}

	public void setAct(String act) {
		this.act=act;
	} 

	public String getAct(){
		return act;
	}

	public void setFlag(String flag) {
		this.flag=flag;
	} 

	public String getFlag(){
		return flag;
	}

	public void setIcon(String icon) {
		this.icon=icon;
	} 

	public String getIcon(){
		return icon;
	}

	public void setCss(String css) {
		this.css=css;
	} 

	public String getCss(){
		return css;
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