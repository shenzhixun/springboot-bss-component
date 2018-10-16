package com.ejet.bss.userflow.comm.constant;

/**
 *
 * 抄送人类别
 * 
 * 0：无抄送人员，1：按角色，2：按人员
 * 
 * @author ShenYijie
 */
public enum FlowCcTypeEm {
	
	NONE(0), 	
	CC_BY_ROLE(1),
	CC_BY_USER(1);
	
	private int value;
	
	private FlowCcTypeEm(int value) {
		this.value = value;
	}
	
	public static FlowCcTypeEm getTypeByValue(int value) {
		for (FlowCcTypeEm c : FlowCcTypeEm.values()) {
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
