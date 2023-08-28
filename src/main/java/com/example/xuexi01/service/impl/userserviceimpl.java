package com.example.xuexi01.service.impl;


import com.example.xuexi01.dao.userdao;
import com.example.xuexi01.entity.user;
import com.example.xuexi01.entity.u;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
/*@Transactional*/
public class userserviceimpl implements com.example.xuexi01.service.userservice {


    private userdao userdao;

    @Autowired
    public userserviceimpl(com.example.xuexi01.dao.userdao userdao) {
        this.userdao = userdao;
    }

    @Override
    public user finduserbyid(Integer uid){
        return this.userdao.selectByuId(uid);
    }
    /*
    * 删除
    * */
    @Override
    public void delete(Integer uid){
        this.userdao.deleteuser(uid);
    }
    /*
    * 更新
    * */
    @Override
    public void updateuser(user user){
        this.userdao.updateuser(user);
    }
    /*
    * 列表
    * */
    @Override
    public List<user> list() {
        return userdao.userList();
    }

    @Override
    public  List<user> userselect(String userpermissions, String xuanze, String neirong, String id){
        return  userdao.userselect(userpermissions,xuanze,neirong,id);
    }
    /*
    * 获取用户权限
    * */
    @Override
    public List<u> upermissions(){
        return userdao.upermissions();
    }
    /*
    * 登录
    * */

    @Override
    public user login(String uname, String password) {
        //1.根据用户输入用户名查询数据中是否存在
        user user = userdao.selectbyname(uname);
        //2.判断对象是否存在
        if (ObjectUtils.isEmpty(user)) throw new RuntimeException("用户名输入错误!");
        //3.判断密码正确性
        if (!user.getPassword().equals(password)) throw new RuntimeException("密码输入错误!");
        return user;
    }
    /*
     * 注册
     *
     * */
    @Override
    public void regist(user user) {
        //1.根据用户查询数据库是否存在改用户名
        user userdb = userdao.selectbyname(user.getUname());
        if (!ObjectUtils.isEmpty(userdb)) {
            throw new RuntimeException("用户已存在！");
        }
        //2.注册
        userdao.insertuser(user);
    }

}


