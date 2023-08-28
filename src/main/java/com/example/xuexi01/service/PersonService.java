package com.example.xuexi01.service;

import com.example.xuexi01.entity.Person;
import com.example.xuexi01.entity.Ps;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PersonService {



    int getcount(String uid,String sectorid,String nianling,String xuanze,String neirong);

    @Transactional
    void addperson(Person person);

    List<Ps> select(String uid,String sectorid, String nianling,String xuanze,String neirong,String pages);

    //按id升序排列
    List<Ps> list();
    Person findpersonbyid(Integer id);
    void updateperson(Person person);
    void delete(Integer id);
}
