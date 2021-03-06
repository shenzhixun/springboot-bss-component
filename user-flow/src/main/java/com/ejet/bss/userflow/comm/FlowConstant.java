package com.ejet.bss.userflow.comm;

/**
 * Copyright (C), 2016-2018, 武汉康华数海有限公司
 * FileName: FlowConstant
 * Author:   ShenYijie
 * CreateDate:     2018-10-15 20:17
 * Description: 常量
 * History:
 * Version: 1.0
 */
public class FlowConstant {

    public static final int TRANSACTION_TIME_OUT = 3600;

    /** 审批状态, 1: 等待审批，2: 正在审批，3：审批完成 */
    public static final Integer FLOW_APPROVE_STATUS_START = 1;
    /** 审批状态, 1: 等待审批，2: 正在审批，3：审批完成 */
    public static final Integer FLOW_APPROVE_STATUS_GOING = 2;
    /** 审批状态, 1: 等待审批，2: 正在审批，3：审批完成 */
    public static final Integer FLOW_APPROVE_STATUS_OVER = 3;


    /** 审批结果, 0: 审核中， 1: 同意，2：拒绝 */
    public static final Integer FLOW_APPROVE_RESULT_GOING = 0;
    /** 审批结果, 0: 审核中， 1: 同意，2：拒绝 */
    public static final Integer FLOW_APPROVE_RESULT_OK = 1;
    /** 审批结果, 0: 审核中， 1: 同意，2：拒绝 */
    public static final Integer FLOW_APPROVE_RESULT_REFUSE = 2;




}
