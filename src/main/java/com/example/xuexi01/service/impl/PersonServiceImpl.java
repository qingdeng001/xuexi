package com.example.xuexi01.service.impl;

import com.example.xuexi01.dao.PersonDao;
import com.example.xuexi01.entity.Person;
import com.example.xuexi01.entity.Ps;
import com.example.xuexi01.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;


    @Override
    public List<Ps> select(String uid,String sectorid, String nianling,String xuanze ,String neirong,String pages){
        return personDao.select(uid,sectorid,nianling,xuanze,neirong,pages);
    }
    @Override
    public int getcount(String uid,String sectorid,String nianling,String xuanze,String neirong){
        return this.personDao.getCount(uid,sectorid,nianling,xuanze,neirong);
    }
    //添加
    @Override
    public void addperson(Person person){
        this.personDao.insertperson(person);
    }
    //用户列表
    @Override
    public List<Ps> list() {
        return personDao.personList();
    }
    //按id查询信息
    @Override
    public Person findpersonbyid(Integer id){
        return this.personDao.selectById(id);
    }
    //更新人员信息
    @Override
    public void updateperson(Person person){
        this.personDao.updateperson(person);
    }


    //删除
    @Override
    public void delete(Integer id){
        this.personDao.deleteperson(id);
    }






}

