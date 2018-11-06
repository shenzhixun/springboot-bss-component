package com.ejet.bss.userflow.bo;

import java.util.List;

/**
 * 保存流程信息Vo
 * 
 * @author ShenYijie
 *
 */
public class BssFlowRequestBO {
		
    /**  业务类型 (表单类型)  */
    private String bussType;
    /**  业务UUID ( 表单id) */
    private String bussUuid;
	/**
	 * 分支流程
	 */
	private BssFlowBO flowBO;

    public String getBussType() {
        return bussType;
    }

    public void setBussType(String bussType) {
        this.bussType = bussType;
    }

    public String getBussUuid() {
        return bussUuid;
    }

    public void setBussUuid(String bussUuid) {
        this.bussUuid = bussUuid;
    }

    public BssFlowBO getFlowBO() {
        return flowBO;
    }

    public void setFlowBO(BssFlowBO flowBO) {
        this.flowBO = flowBO;
    }
}
