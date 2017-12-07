package com.example.retrofit.model;

/**
 * 登录用户名密码模型
 * @author zyl
 * @version 1.0
 * @date 2017/12/4
 */

public class UserInfo {
    private String userName;
    
    private String passWord;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "LoginInfo{" + "userName='" + userName + '\'' + ", passWord='" + passWord + '\'' + '}';
    }
}
