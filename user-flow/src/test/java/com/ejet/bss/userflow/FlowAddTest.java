package com.ejet.bss.userflow;

import com.ejet.base.BaseTest;
import com.ejet.bss.userflow.bo.BssFlowNodeBO;
import com.ejet.bss.userflow.bo.BssFlowBO;
import com.ejet.bss.userflow.bo.BssFlowRequestBO;
import com.ejet.bss.userflow.comm.em.FlowApproverEm;
import com.ejet.bss.userflow.comm.em.FlowCcTypeEm;
import com.ejet.bss.userflow.comm.em.FlowNodeApproveModeEm;
import com.ejet.bss.userflow.model.BssFlowModel;
import com.ejet.bss.userrights.model.SysAccountRoleRModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2016-2018, 武汉康华数海有限公司
 * FileName: FlowAddTest
 * Author:   ShenYijie
 * CreateDate:     2018-11-05 20:25
 * Description:
 * History:
 * Version: 1.0
 */
public class FlowAddTest extends BaseTest {


    /**
     * 上级主管审批
     * @param flow
     * @return
     */
    public static BssFlowNodeBO getNodeDirector(BssFlowModel flow) {
        BssFlowNodeBO node = new BssFlowNodeBO();
        //node.setId(1);
        node.setNodeName("上级主管审批");

        node.setFlowId(flow.getFlowId());
        node.setNodeType("director");

        /**  审批人类别， 1：主管-指定一级 2：主管-连续多级 3：指定成员 4：角色（一组固定成员）5：发起人自己  */
        node.setApproverPersonType(FlowApproverEm.DIRECTOR_ONE.getValue());

        /**  审批方式 ， 1:依次审批（本环节内审批人依次审批）2:会签（须所有审批人同意）,3:或签（一名审批人同意或拒绝即可）4:发起人从角色成员自选，   */
        node.setApproveMode(FlowNodeApproveModeEm.NODE_SOMEONE.getValue());

        // List<SysAccountRoleRModel> approveUsers = new ArrayList<>();
        // SysAccountRoleRModel userrole = new SysAccountRoleRModel();
        // userrole.setRoleId(1); //人力主管
        // approveUsers.add(userrole);
        // node.setApproveUsers(approveUsers);


        /**  审批深度：只对直到第几级主管  */
        node.setApproveDepth(1);

        ///**  0: 不查找上级, 1:若该审批人空缺，由其在通讯录中的上级主管代审批， 2：提示流程错误  */
        node.setApproverFill(1);

        return node;
    }

    /**
     * 指定角色审批
     *
     * @param flow
     * @return
     */
    public static BssFlowNodeBO getNodeRoles(BssFlowModel flow) {
        BssFlowNodeBO node = new BssFlowNodeBO();
        //node.setId(2);
        node.setNodeName("角色审批");
        node.setFlowId(flow.getFlowId());
        node.setNodeType("role");

        /**  审批人类别， 1：主管-指定一级 2：主管-连续多级 3：指定成员 4：角色（一组固定成员）5：发起人自己  */
        node.setApproverPersonType(FlowApproverEm.DIRECTOR_ROLES.getValue());

        /**  审批方式 ， 1:依次审批（本环节内审批人依次审批）2:会签（须所有审批人同意）,3:或签（一名审批人同意或拒绝即可）4:发起人从角色成员自选，   */
        node.setApproveMode(FlowNodeApproveModeEm.NODE_SEQUENCE.getValue());


        List<SysAccountRoleRModel> approveUsers = new ArrayList<>();
        SysAccountRoleRModel userrole = new SysAccountRoleRModel();
        userrole.setRoleId(1); //人力主管
        approveUsers.add(userrole);
        node.setApproveUsers(approveUsers);

        /**  审批深度：只对直到第几级主管  */
        node.setApproveDepth(1);

        ///**  0: 不查找上级, 1:若该审批人空缺，由其在通讯录中的上级主管代审批， 2：提示流程错误  */
        node.setApproverFill(1);

        return node;
    }






    public static BssFlowBO addFlow() {

        BssFlowModel flow = new BssFlowModel();
        flow.setId(1);
        flow.setFlowId(1);
        flow.setFlowCode("upload");
        flow.setFlowType("default");
        flow.setFlowName("上报审核");
        flow.setFullname("病案上报审核流程");
        flow.setFlowVersion("1.0");
        flow.setPriority(1);
        flow.setRemark("病案上报审核流程");

        //抄送角色
        flow.setCcType(FlowCcTypeEm.CC_BY_ROLE.getValue()); //角色
        flow.setCcUsers(null);



        List<BssFlowNodeBO> nodes = new ArrayList<>();
        BssFlowNodeBO node1 = getNodeDirector(flow);
        node1.setNodeStep(1);

        BssFlowNodeBO node2 = getNodeRoles(flow);
        node2.setNodeStep(2);
        nodes.add(node1);
        nodes.add(node2);

        BssFlowBO flowVO = new BssFlowBO();

        flowVO.setFlow(flow);
        flowVO.setFlowNodes(nodes);

        return flowVO;
    }



    public static void main(String[] args) {

        BssFlowRequestBO bo = new BssFlowRequestBO();
        bo.setBussUuid("123");
        bo.setBussType("leave");
        bo.setFlowBO(addFlow());

        String result = gson.toJson(bo);

        System.out.println(result);
    }

}
