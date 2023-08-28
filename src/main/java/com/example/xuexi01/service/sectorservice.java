package com.example.xuexi01.service;

import com.example.xuexi01.entity.sector;

import java.util.List;

public interface sectorservice {
    List<sector> sectorselect(String xuanze, String neirong, String uid);

    Integer insertsector(sector sector);

    List<sector> list();

    void update(sector sector);

    sector selectById(int id);

    void delete(String id);
}
