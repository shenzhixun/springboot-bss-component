package com.ejet.bi.dynamicservice.constant;

/**
 * 参数类型定义
 */
public enum ParamConditionEnum {

    UNKNOWN("UNKNOWN", "UNKNOWN类型"),
    NOT_EQUALS("1", "!="),      //如果值不等于
    CONTAINS("2", "数字类型"),  //如果值包含
    NOT_CONTAINS("3", "不包含"), //
    START_WITH("4", "值的开始是"); //值的开始是

    private String name;
    private String desc;

    private ParamConditionEnum(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }


    public static ParamConditionEnum getTypeName(String name) {
        if(name == null || "".equals(name.trim())){
            return null;
        }
        for (ParamConditionEnum c : ParamConditionEnum.values()) {
            if(c.getName().equals(name.trim().toLowerCase())){
                return c;
            }
        }
        return null;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
