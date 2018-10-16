package com.ejet.bss.userflow.vo;

import com.ejet.bss.userflow.bo.SysFlowNodeVo;
import com.ejet.bss.userflow.model.BssFlowModel;
import com.ejet.bss.userrights.model.SysAccountRoleRModel;

import java.util.List;

public class BssFlowVO extends BssFlowModel {
    /** 业务ID */
    private String bussUuid;
    /** 表单类型 */
    private String bussType;
    /**
     * 流程节点
     */
    private List<SysFlowNodeVo> flowNodes;
    /**
     * 	抄送类型
     */
    private Integer ccType;
    /**
     * 	抄送人或者角色
     */
    private List<SysAccountRoleRModel> ccUserList;

    public String getBussUuid() {
        return bussUuid;
    }

    public void setBussUuid(String bussUuid) {
        this.bussUuid = bussUuid;
    }

    public String getBussType() {
        return bussType;
    }

    public void setBussType(String bussType) {
        this.bussType = bussType;
    }

    public List<SysFlowNodeVo> getFlowNodes() {
        return flowNodes;
    }

    public void setFlowNodes(List<SysFlowNodeVo> flowNodes) {
        this.flowNodes = flowNodes;
    }

    @Override
    public Integer getCcType() {
        return ccType;
    }

    @Override
    public void setCcType(Integer ccType) {
        this.ccType = ccType;
    }

    public List<SysAccountRoleRModel> getCcUserList() {
        return ccUserList;
    }

    public void setCcUserList(List<SysAccountRoleRModel> ccUserList) {
        this.ccUserList = ccUserList;
    }
}