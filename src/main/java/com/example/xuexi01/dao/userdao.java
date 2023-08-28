package com.example.xuexi01.dao;

import com.example.xuexi01.entity.u;
import com.example.xuexi01.entity.user;

import java.util.List;

public interface userdao {


    Integer deleteuser(int uid);

    /*
     * 按id查询
     * */
    user selectByuId(Integer uid);

    Integer updateuser(user user);

    List<user> userList();

    List<user> userselect(String userpermissions,String xuanze,String neirong,String id);

    List<u> upermissions();

    /*
    *按照名称查找信息
    */
    user selectbyname(String uname);

    Integer insertuser(user user);


}
