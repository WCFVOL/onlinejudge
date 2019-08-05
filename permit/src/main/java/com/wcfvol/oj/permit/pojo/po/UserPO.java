package com.wcfvol.oj.permit.pojo.po;

import java.util.Date;

public class UserPO {
    /**
     * 自增id 
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 注册时间
     */
    private Date genTime;

    /**
     * 首次登陆时间
     */
    private Date loginTime;

    /**
     * 最后一次登陆时间
     */
    private Date lastLoginTime;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 盐
     */
    private String salt;

    /**
     * 加密后的密码
     */
    private String password;

    /**
     * 自增id 
     * @return id 自增id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 自增id 
     * @param id 自增id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 用户名
     * @return username 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 用户名
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 邮箱
     * @return email 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 邮箱
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 注册时间
     * @return gen_time 注册时间
     */
    public Date getGenTime() {
        return genTime;
    }

    /**
     * 注册时间
     * @param genTime 注册时间
     */
    public void setGenTime(Date genTime) {
        this.genTime = genTime;
    }

    /**
     * 首次登陆时间
     * @return login_time 首次登陆时间
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * 首次登陆时间
     * @param loginTime 首次登陆时间
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * 最后一次登陆时间
     * @return last_login_time 最后一次登陆时间
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 最后一次登陆时间
     * @param lastLoginTime 最后一次登陆时间
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * 手机号
     * @return mobile 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 手机号
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 盐
     * @return salt 盐
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 盐
     * @param salt 盐
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * 加密后的密码
     * @return password 加密后的密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 加密后的密码
     * @param password 加密后的密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}