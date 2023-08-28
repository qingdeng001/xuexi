package com.example.xuexi01.dao;

import com.example.xuexi01.entity.sector;

import java.util.List;

public interface sectordao {
    List<sector> sectorselect(String xuanze, String neirong, String uid);

    Integer instersector(sector sector);

    Integer delete(String id);

    List<sector> sectorList();

    Integer update(sector sector);

    sector selectById(int id);
}
