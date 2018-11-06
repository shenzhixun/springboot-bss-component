package com.ejet.bss.userflow.comm.em;


/**
 *
 * 审批人类别， 1：主管-指定一级 2：主管-连续多级 3：指定成员 4：角色（一组固定成员）5：发起人自己
 * 
 * @author ShenYijie
 */
public enum FlowApproverEm {
	
	DIRECTOR_ONE(1), 	
	DIRECTOR_MULTI(2),
	DIRECTOR_USERS(3),
	/**
	 * 4：角色（一组固定成员）
	 */
	DIRECTOR_ROLES(4),
	DIRECTOR_SELF(5),;
	
	private int value;
	
	private FlowApproverEm(int value) {
		this.value = value;
	}
	
	public static FlowApproverEm getTypeByValue(int value) {
		for (FlowApproverEm c : FlowApproverEm.values()) {
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
