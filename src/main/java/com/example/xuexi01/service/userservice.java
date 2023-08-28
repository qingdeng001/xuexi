package com.example.xuexi01.service;

import com.example.xuexi01.entity.u;
import com.example.xuexi01.entity.user;

import java.util.List;

public interface userservice {


    user finduserbyid(Integer uid);

    /*
    * 删除
    * */
    void delete(Integer uid);

    void updateuser(user user);

    //列表
    List<user> list();


    List<user> userselect(String userpermissions,String xuanze,String neirong,String id);

    List<u> upermissions();

    //登录
    user login(String uname, String password);


    //注册
    void regist(user user);
}
