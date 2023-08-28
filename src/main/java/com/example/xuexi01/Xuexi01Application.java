package com.example.xuexi01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetAddress;

@SpringBootApplication
public class Xuexi01Application {

    public static void main(String[] args) {
        SpringApplication.run(Xuexi01Application.class, args);


        try {
            InetAddress addr = InetAddress.getLocalHost();
            Runtime.getRuntime().exec("cmd   /c   start   http://localhost:8090/xuexi02/login.jsp");//可以指定自己的路径
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}
