package com.example.xuexi01.entity;

public class sector {
    private int id              ;
    private String sector_name     ;
    private String sector_address  ;


    public sector() {
    }

    public sector(int id, String sector_name, String sector_address) {
        this.id = id;
        this.sector_name = sector_name;
        this.sector_address = sector_address;
    }

    @Override
    public String toString() {
        return "sector{" +
                "id='" + id + '\'' +
                ", sector_name='" + sector_name + '\'' +
                ", sector_address='" + sector_address + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSector_name() {
        return sector_name;
    }

    public void setSector_name(String sector_name) {
        this.sector_name = sector_name;
    }

    public String getSector_address() {
        return sector_address;
    }

    public void setSector_address(String sector_address) {
        this.sector_address = sector_address;
    }
}
