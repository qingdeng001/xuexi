package com.example.xuexi01.dao.impl;


import com.example.xuexi01.entity.sector;
import com.example.xuexi01.utils.JDBCUtil;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class sectordaoimpl implements com.example.xuexi01.dao.sectordao {




    @Override
    public List<sector> sectorselect(String xuanze, String neirong, String uid){
        Connection connection = JDBCUtil.getConnection();
        String a = null;
        String b = null;
        String c = " order by ";
        if (Objects.equals(neirong, "")){
            xuanze = "";
        }
        if (Objects.equals(xuanze, "")){
            neirong = "";
        }
        switch (xuanze){
            case "id":
                a = " and id like '%";
                b = "%'";
                break;
            case "sector_name":
                a = " and sector_name like '%";
                b = "%'";
                break;
            case "sector_address":
                a = " and sector_address like '%";
                b = "%'";
                break;
            default:
                a = "";
                b = "";
                break;
        }
        if (uid == null){
            c = "";
            uid = "";
        }
        String sql = "select * from sector where 1=1 "+a+neirong+b+c+uid;
        System.out.println(sql);
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<sector> sectors = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String sector_name = resultSet.getString(2);
                String sector_address = resultSet.getString(3);
                sectors.add(new sector(id,sector_name,sector_address));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sectors;
    }

    /*
    * 添加部门信息
    * */
    @Override
    public Integer instersector(sector sector){
        Connection connection = JDBCUtil.getConnection();
        String sql = "insert into sector(id, sector_name, sector_address) VALUES(?,?,?) ";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,sector.getId());
            statement.setString(2,sector.getSector_name());
            statement.setString(3,sector.getSector_address());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    @Override
    public Integer delete(String id){
        Connection connection =JDBCUtil.getConnection();
        String sql = "delete from sector where id = '"+id+"'";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            result = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public List<sector> sectorList(){
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from sector";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<sector> sectors = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String sector_name = resultSet.getString(2);
                String sector_address = resultSet.getString(3);
                sectors.add(new sector(id, sector_name, sector_address));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.release(connection, statement, resultSet);
        }
        return sectors;
    }


    @Override
    public Integer update(sector sector){
        Connection connection = JDBCUtil.getConnection();
        String sql = "update sector set sector_name=?,sector_address=? where id = ?";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,sector.getSector_name());
            statement.setString(2,sector.getSector_address());
            statement.setInt(3,sector.getId());
            result = statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return  result;

    }

    @Override
    public sector selectById(int id){
        Connection connection = JDBCUtil.getConnection();
        String sql="select * from sector where  id = '"+id+"'";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            if (resultSet.next()){
                id =resultSet.getInt(1);
                String sector_name = resultSet.getString(2);
                String sector_address = resultSet.getString(3);
               return new sector(id,sector_name,sector_address);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


}
