package com.ejet.bi.dynamicservice.constant;

/**
 * 参数类型定义
 */
public enum ParamTypeEnum {

    UNKNOWN("UNKNOWN", "UNKNOWN类型"),
    STRING("string", "字符串类型"),
    NUMBER("number", "数字类型"),
    DATE_TIME("datetime", "date日期时间类型"),
    BOOLEAN("boolean", "bool类型");

    private String name;
    private String desc;

    private ParamTypeEnum(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }


    public static ParamTypeEnum getTypeName(String name) {
        if(name == null || "".equals(name.trim())){
            return null;
        }
        for (ParamTypeEnum c : ParamTypeEnum.values()) {
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
