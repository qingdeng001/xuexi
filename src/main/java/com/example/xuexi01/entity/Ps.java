package com.example.xuexi01.entity;

import java.sql.Date;
import java.sql.Timestamp;

public class Ps {

    private int         id                  ;
    private String      name                ;
    private Integer     age                 ;
    private String      sex                 ;
    private Date        birthday            ;
    private String      telephone_number    ;
    private String      email               ;
    private Timestamp   onboarding_time     ;
    private String      post                ;
    private int         monthly_salary      ;
    private int         bonus               ;
    private String      sector_name         ;



    public Ps() {
    }

    public Ps(int id, String name, Integer age, String sex, Date birthday, String telephone_number, String email, Timestamp onboarding_time, String post, int monthly_salary, int bonus, String sector_name) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.birthday = birthday;
        this.telephone_number = telephone_number;
        this.email = email;
        this.onboarding_time = onboarding_time;
        this.post = post;
        this.monthly_salary = monthly_salary;
        this.bonus = bonus;
        this.sector_name = sector_name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getTelephone_number() {
        return telephone_number;
    }

    public void setTelephone_number(String telephone_number) {
        this.telephone_number = telephone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getOnboarding_time() {
        return onboarding_time;
    }

    public void setOnboarding_time(Timestamp onboarding_time) {
        this.onboarding_time = onboarding_time;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public int getMonthly_salary() {
        return monthly_salary;
    }

    public void setMonthly_salary(int monthly_salary) {
        this.monthly_salary = monthly_salary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public String getSector_name() {
        return sector_name;
    }

    public void setSector_name(String sector_name) {
        this.sector_name = sector_name;
    }
}
