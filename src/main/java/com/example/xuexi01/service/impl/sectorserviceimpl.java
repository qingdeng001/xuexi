package com.example.xuexi01.service.impl;

import com.example.xuexi01.dao.sectordao;
import com.example.xuexi01.entity.sector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class sectorserviceimpl implements com.example.xuexi01.service.sectorservice {

    @Autowired
    private sectordao sectordao;


    @Override
    public List<sector> sectorselect(String xuanze,String neirong,String uid ){
        return (sectordao.sectorselect(xuanze, neirong, uid));
    }
    @Override
    public Integer insertsector(sector sector){
        return this.sectordao.instersector(sector);
    }
    @Override
    public List<sector> list(){
        return sectordao.sectorList();
    }


    @Override
    public void update(sector sector){
        this.sectordao.update(sector);
    }

    @Override
    public sector selectById(int id){
        return this.sectordao.selectById(id);
    }

    @Override
    public void delete(String id){
        this.sectordao.delete(id);
    }
}
