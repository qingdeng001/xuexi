package com.example.xuexi01.dao.impl;

import com.example.xuexi01.dao.PersonDao;
import com.example.xuexi01.entity.Person;
import com.example.xuexi01.entity.Ps;
import com.example.xuexi01.utils.JDBCUtil;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class PersonDaoImpl implements PersonDao {

    @Override
    public List<Ps> select(String uid,String sectorid,String nianling,String xuanze,String neirong,String pages){
        Connection connection = JDBCUtil.getConnection();
        String aa = "";
        String sql =null;
        String a = null;
        String b = null;
        String c = " order by ";
        //每页最大行数
        int maxresult = 10;
        int offset = 0;
        String d = "";
        int page = 1;
        if (pages != null && !"".equals(pages.trim())){
            page = Integer.parseInt(pages);
            offset = (page-1)*maxresult;
            if (offset<=0){
                offset = 0;
            }
            d=" limit "+offset+","+maxresult;
        }

        if (Objects.equals(neirong, "")){
            xuanze = "";
        }
        if (Objects.equals(xuanze, "")){
            neirong = "";
        }
        if (sectorid!= ""){
            aa = "and sector_id = ";
        }
        switch (xuanze){
            case "id":
                a=" and person.id like '%";
                b="%'";
                break;
            case "name":
                a=" and name like '%";
                b="%'";
                break;
            case "sector_name":
                a = " and sector_name like '%";
                b="%'";
                break;
            default:
                a = "";
                b = "";
        }
        if (uid==null || uid.equals("")){
            c = "";
            uid = "";
        }
            sql = "select person.id, name, age, sex, birthday, " +
                    "telephone_number, email, onboarding_time, post, " +
                    "monthly_salary, bonus, sector_name  from person,sector " +
                    "where person.sector_id=sector.id "+aa+sectorid +nianling+a+neirong+b+c+uid+d;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Ps> persons = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int age = resultSet.getInt(3);
                String sex = resultSet.getString(4);
                Date birthday = resultSet.getDate(5);
                String telephone_number = resultSet.getString(6);
                String email = resultSet.getString(7);
                Timestamp onboarding_time = resultSet.getTimestamp(8);
                String post = resultSet.getString(9);
                int monthly_salary = resultSet.getInt(10);
                int bonus = resultSet.getInt(11);
                String sector_name = resultSet.getString(12);
                persons.add(new Ps(id,name,age,sex,birthday,telephone_number,email,onboarding_time,
                        post,monthly_salary,bonus,sector_name));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return persons;
    }

    @Override
    public int getCount(String uid,String sectorid, String nianling,String xuanze,String neirong) {
        int count = 0;
        String aa = "";
        String a = null;
        String b = null;
        if (Objects.equals(neirong, "")){
            xuanze = "";
        }
        if (Objects.equals(xuanze, "")){
            neirong = "";
        }
        if (!Objects.equals(sectorid, "")){
            aa = "and sector_id = ";
        }
        switch (xuanze) {
            case "id" -> {
                a = " and person.id like '%";
                b = "%'";
            }
            case "name" -> {
                a = " and name like '%";
                b = "%'";
            }
            case "sector_name" -> {
                a = " and sector_name like '%";
                b = "%'";
            }
            default -> {
                a = "";
                b = "";
            }
        }
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "select count(*) as count from person where 1=1 "+aa+sectorid +nianling+a+neirong+b;
        try {
            statement=connection.prepareStatement(sql);
            resultSet=statement.executeQuery();
            if(resultSet.next()) {
                count=resultSet.getInt(1);
            }
        } catch (Exception e) {
        }
        return count;
    }
    /*
    * 添加用户
    *
    * */
    @Override
    public Integer insertperson(Person person) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "insert into person(name, age, sex, birthday, " +
                "telephone_number, email, onboarding_time, post, " +
                "monthly_salary, bonus, sector_id)" +
                " VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = null;
        Integer result = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,person.getName());
            statement.setInt(2,person.getAge());
            statement.setString(3,person.getSex());
            statement.setDate(4, person.getBirthday());
            statement.setString(5,person.getTelephone_number());
            statement.setString(6, person.getEmail());
            statement.setTimestamp(7,person.getOnboarding_time());
            statement.setString(8,person.getPost());
            statement.setInt(9,person.getMonthly_salary());
            statement.setInt(10,person.getBonus());
            statement.setInt(11,person.getSector_id());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    /*
    * 用户列表
    * */

    @Override
    public List<Ps> personList(){
        Connection connection = JDBCUtil.getConnection();
        String sql = "select person.id, name, age, sex, birthday, " +
                "telephone_number, email, onboarding_time, post, " +
                "monthly_salary, bonus, sector_name from person,sector " +
                "where person.sector_id=sector.id";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Ps> persons = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int age = resultSet.getInt(3);
                String sex = resultSet.getString(4);
                Date birthday = resultSet.getDate(5);
                String telephone_number = resultSet.getString(6);
                String email = resultSet.getString(7);
                Timestamp onboarding_time = resultSet.getTimestamp(8);
                String post = resultSet.getString(9);
                int monthly_salary = resultSet.getInt(10);
                int bonus = resultSet.getInt(11);
                String sector_name = resultSet.getString(12);

                persons.add(new Ps(id,name,age,sex,birthday,telephone_number,email,onboarding_time,
                        post,monthly_salary,bonus,sector_name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return persons;
    }



    /*
    * 按id查询
    * */
    @Override
    public Person selectById(int id){
        Connection connection = JDBCUtil.getConnection();
        String sql="select * from person where  id = "+id;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            if (resultSet.next()){
                id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int age = resultSet.getInt(3);
                String sex = resultSet.getString(4);
                Date birthday = resultSet.getDate(5);
                String telephone_number = resultSet.getString(6);
                String email = resultSet.getString(7);
                Timestamp onboarding_time = resultSet.getTimestamp(8);
                String post = resultSet.getString(9);
                int monthly_salary = resultSet.getInt(10);
                int bonus = resultSet.getInt(11);
                int sector_id = resultSet.getInt(12);
                return new Person(id,name,age,sex,birthday,telephone_number,email,onboarding_time,
                        post,monthly_salary,bonus,sector_id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
        }



        /*
        * 更新
        * */
        @Override
        public Integer updateperson(Person person){
            Connection connection = JDBCUtil.getConnection();
            String sql = "update person set name=?, " +
                    "age=?,sex=?,birthday=?,telephone_number=?, " +
                    "email=?,onboarding_time=? ,post=?,monthly_salary=?," +
                    " bonus=?,sector_id=? where id = ?";
            System.out.println(sql);

            PreparedStatement statement = null;
            Integer result = null;
            try {
                statement = connection.prepareStatement(sql);
                statement.setString(1,person.getName());
                statement.setInt(2,person.getAge());
                statement.setString(3,person.getSex());
                statement.setDate(4,person.getBirthday());
                statement.setString(5,person.getTelephone_number());
                statement.setString(6,person.getEmail());
                statement.setTimestamp(7,person.getOnboarding_time());
                statement.setString(8,person.getPost());
                statement.setInt(9,person.getMonthly_salary());
                statement.setInt(10,person.getBonus());
                statement.setInt(11,person.getSector_id());
                statement.setInt(12,person.getId());
                result = statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return result;
        }




        /*
        * 删除
        * */
        @Override
        public Integer deleteperson(Integer id){
            Connection connection = JDBCUtil.getConnection();
            String sql = "delete from person where id="+id;
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






    }

