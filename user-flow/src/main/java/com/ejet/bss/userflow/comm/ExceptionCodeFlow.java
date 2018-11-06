package com.ejet.bss.userflow.comm;

/**
 * Copyright (C), 2016-2018, 武汉康华数海有限公司
 * FileName: ExceptionCodeFlow
 * Author:   ShenYijie
 * CreateDate:     2018-10-15 19:26
 * Description: 返回码
 * History:
 * Version: 1.0
 */
public class ExceptionCodeFlow extends com.ejet.comm.exception.ExceptionCode {

    /** 表单ID、类型为空 */
    public static final String FLOW_ADD_FORM_EMPTY = "500001";
    /** 流程名称为空 */
    public static final String FLOW_ADD_FLOW_NAME_EMPTY = "500002";
    /** 流程优先级为空 */
    public static final String FLOW_ADD_FLOW_PRIORITY_EMPTY = "500003";
    /** 流程节点为空 */
    public static final String FLOW_ADD_FLOW_NODES_EMPTY = "500004";
    /** 流程节点审批人类别为空 */
    public static final String FLOW_ADD_NODE_APPROVER_PERSON_TYPE = "500005";
    /** 流程节点审批方式为空 */
    public static final String FLOW_ADD_NODE_APPROVER_MODE = "5000006";
    /** 流程节点找不到对应审批人 */
    public static final String FLOW_ADD_NODE_APPROVER_EMPTY = "5000007";

    /** 流程为空 */
    public static final String FLOW_ADD_FLOW_NULL = "500008";


    static {
        System.out.println("***(((((ExceptionCodeFlow***" + messageMap.size());
        put(FLOW_ADD_FLOW_NULL, "流程为空");
        put(FLOW_ADD_FORM_EMPTY, "表单ID、类型为空");
        put(FLOW_ADD_FLOW_NAME_EMPTY, "流程名称为空");
        put(FLOW_ADD_FLOW_PRIORITY_EMPTY, "流程优先级为空");
        put(FLOW_ADD_FLOW_NODES_EMPTY, "流程节点为空");
        put(FLOW_ADD_NODE_APPROVER_PERSON_TYPE, "流程节点审批人类别为空");
        put(FLOW_ADD_NODE_APPROVER_MODE, "流程节点审批方式为空");
        put(FLOW_ADD_NODE_APPROVER_EMPTY, "流程节点找不到对应审批人");
    }

}
