package com.ejet.bss.userflow.comm.em;

/**
 *
 * 节点审批方式
 * 
 * 1：依次审批（本环节内审批人依次审批） 2：会签（须所有审批人同意） 3：或签（一名审批人同意或拒绝即可）
 *   4：发起人从角色成员中自选
 *   5：发起人自己 
 * 
 * @author ShenYijie
 */
public enum FlowNodeApproveModeEm {
	
	NODE_SEQUENCE(1), 	
	NODE_ALL(2),
	NODE_SOMEONE(3),  
	NODE_CHOSE(4),
	SELF(5);
	
	private int value;
	
	private FlowNodeApproveModeEm(int value) {
		this.value = value;
	}
	
	public static FlowNodeApproveModeEm getTypeByValue(int value) {
		for (FlowNodeApproveModeEm c : FlowNodeApproveModeEm.values()) {
            if (c.value == value) {
                return c;
            }
        }
        return null;
	}
	public int getValue() {
		return this.value;
	}
}
