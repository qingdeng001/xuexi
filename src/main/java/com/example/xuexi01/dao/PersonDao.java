package com.example.xuexi01.dao;

import com.example.xuexi01.entity.Person;
import com.example.xuexi01.entity.Ps;

import java.util.List;

public interface PersonDao {
    List<Ps> select(String uid,String sectorid, String nianling,String xuanze,String neirong,String pages);
    int getCount(String uid,String sectorid, String nianling,String xuanze,String neirong);

    Integer insertperson(Person person);
    List<Ps> personList();

    Person selectById(int id);
    Integer updateperson(Person person);
    Integer deleteperson(Integer id);
}
