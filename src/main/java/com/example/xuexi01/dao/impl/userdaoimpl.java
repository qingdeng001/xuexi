package com.example.xuexi01.dao.impl;

import com.example.xuexi01.entity.user;
import com.example.xuexi01.entity.u;
import com.example.xuexi01.utils.JDBCUtil;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class userdaoimpl implements com.example.xuexi01.dao.userdao {

    /*
    * 删除用户
    * */
    @Override
    public Integer deleteuser(int uid) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "delete from user where uid = "+uid;
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            result = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, null);
        }
        return result;
    }
    /*
     * 按id查询
     * */
    @Override
    public user selectByuId(Integer uid){
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from user where uid = "+uid;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            if (resultSet.next()){
                 uid = resultSet.getInt(1);
                 String uname = resultSet.getString(2);
                 String realname = resultSet.getString(3);
                 String password = resultSet.getString(4);
                 String gender = resultSet.getString(5);
                 String    permissions = resultSet.getString(6);
                 return new user(uid,uname,realname,password,gender,permissions);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return null;
    }
    /*
    * 用户更新
    * */
    @Override
    public Integer updateuser(user user) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "update user set uname=?,realname=?," +
                "password=?,gender=? ,permissions=? where uid=?";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,user.getUname());
            statement.setString(2,user.getRealname());
            statement.setString(3,user.getPassword());
            statement.setString(4,user.getGender());
            statement.setString(5, user.getPermissions());
            statement.setInt(6,user.getUid());
            result = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
    /*
    * 用户列表
    * */
    @Override
    public List<user> userList() {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from user";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<user> users = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String uname = resultSet.getString(2);
                String realname = resultSet.getString(3);
                String password = resultSet.getString(4);
                String gender = resultSet.getString(5);
                String permissions = resultSet.getString(6);
                users.add(new user(id, uname, realname, password, gender, permissions));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }
    @Override
    public List<user> userselect(String userpermissions,String xuanze,String neirong,String id) {
        Connection connection = JDBCUtil.getConnection();
        String aa = "";
        String sql =null;
        String a = "";
        String b = "";
        String c = " order by ";
        if (Objects.equals(neirong, "")){
            xuanze = "";
        }
        if (Objects.equals(xuanze, "")){
            neirong = "";
        }
        switch (userpermissions){
            case "系统管理员":
                aa="and permissions = '系统管理员' ";
                break;
            case "管理员":
                aa="and permissions = '管理员' ";
                break;
            case "游客":
                aa="and permissions = '游客' ";
                break;
            default:
                aa="";
                break;
        }
        if(id == null){
            c="";
            id="";
        }
        switch (xuanze){
            case "uid":
                a = " and uid like '%";
                b = "%'";
                break;
            case "uname":
                a = " and uname like '%";
                b = "%'";
                break;
        }
        sql = "select * from user where 1=1 "+aa+a+ neirong+b+c+id;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<user> users = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int uid = resultSet.getInt(1);
                String uname = resultSet.getString(2);
                String realname = resultSet.getString(3);
                String password = resultSet.getString(4);
                String gender = resultSet.getString(5);
                String permissions = resultSet.getString(6);
                users.add(new user(uid, uname, realname, password, gender, permissions));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }

    @Override
    public List<u> upermissions(){
        Connection connection = JDBCUtil.getConnection();
        String sql = "select distinct permissions from user";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<u> upermissions = new ArrayList<>();
        try{
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                String permissions = resultSet.getString(1);
                upermissions.add(new u(permissions));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return upermissions;
    }
    /*
    *按照名称查找信息
    */
    @Override
    public user selectbyname(String uname){
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from user where uname = '"+uname+"'";
        PreparedStatement statement=null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            if (resultSet.next()){
                int uid = resultSet.getInt(1);
                uname = resultSet.getString(2);
                String realname = resultSet.getString(3);
                String password = resultSet.getString(4);
                String gender = resultSet.getString(5);
                String permissions = resultSet.getString(6);
                return new user(uid,uname,realname,password,gender,permissions);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    /*
    * 增加用户
    *
    * */
    @Override
    public Integer insertuser(user user) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "insert into user(uname,realname,password,gender) value (?,?,?,?)";
        PreparedStatement statement = null;
        Integer result = null;

        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,user.getUname());
            statement.setString(2,user.getRealname());
            statement.setString(3,user.getPassword());
            statement.setString(4,user.getGender());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

}
