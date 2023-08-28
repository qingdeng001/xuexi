package com.example.xuexi01.controller;

import com.example.xuexi01.entity.sector;
import com.example.xuexi01.service.sectorservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("sector")
public class sectorcontroller {



    private sectorservice sectorservice;

    @Autowired
    public sectorcontroller(com.example.xuexi01.service.sectorservice sectorservice) {
        this.sectorservice = sectorservice;
    }



    @RequestMapping("select")
    public String select(String xuanze,String neirong,String uid,Model model ){
        List<sector> sectors = sectorservice.sectorselect(xuanze, neirong, uid);
        model.addAttribute("sectors",sectors);
        model.addAttribute("xuanze",xuanze);
        model.addAttribute("neirong",neirong);
        return "sectorlist";
    }



    @RequestMapping("addsector")
    public String addsector(sector sector){
        sectorservice.insertsector(sector);
        return "redirect:/sector/list03";
    }

    @RequestMapping("delete")
    public String delete(String id){
        sectorservice.delete(id);
        return "redirect:/sector/list03";
    }


    @RequestMapping("selectbyid")
    public String selectbyid(int id,Model model){
        sector sector = sectorservice.selectById(id);
        model.addAttribute("sector",sector);
        return "updatesectors";
    }


    @RequestMapping("list")
    public String listsector01(Model model,String permissions){
        List<sector> sectors = sectorservice.list();
        model.addAttribute("sectors",sectors);
        switch (permissions){
            case "系统管理员":
                return "addperson01";
            default:
                return "addperson02";
        }
    }
    @RequestMapping("list03")
    public String listsector03(Model model){
        List<sector> sectors = sectorservice.list();
        model.addAttribute("sectors",sectors);

        return "sectorlist";
    }
    @RequestMapping("update")
    public String update(sector sector){
        sectorservice.update(sector);
        return "redirect:/sector/list03";
    }
}
