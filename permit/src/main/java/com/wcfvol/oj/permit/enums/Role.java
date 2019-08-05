package com.wcfvol.oj.permit.enums;

/**
 * @author wangchunfei
 * @description
 * @date 2019-08-01 15:19
 */
public enum Role {
    /**
     * 未登录的访客
     */
    GUEST(0, "访客"),
    /**
     * 学生
     */
    STUDENT(1, "学生"),
    /**
     * 教师
     */
    TEACHER(2, "教师"),
    /**
     * 管理员
     */
    ADMIN(3, "管理员");

    private int code;
    private String desc;

    Role(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
