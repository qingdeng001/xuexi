package com.example.xuexi01.entity;

public class user {

    private int uid;
    private String uname;
    private String realname;
    private String password;
    private String gender;
    private String permissions;


    public user() {
    }

    public user(int uid, String uname, String realname, String password, String gender, String permissions) {
        this.uid = uid;
        this.uname = uname;
        this.realname = realname;
        this.password = password;
        this.gender = gender;
        this.permissions = permissions;
    }
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }
}
