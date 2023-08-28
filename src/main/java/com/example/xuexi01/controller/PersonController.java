package com.example.xuexi01.controller;

import com.example.xuexi01.entity.Person;
import com.example.xuexi01.entity.Ps;
import com.example.xuexi01.entity.sector;
import com.example.xuexi01.service.PersonService;
import com.example.xuexi01.service.sectorservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("person")
public class PersonController {



    private PersonService personService;
    private sectorservice sectorservice;

    @Autowired
    public PersonController(PersonService personService, com.example.xuexi01.service.sectorservice sectorservice) {
        this.personService = personService;
        this.sectorservice = sectorservice;
    }



    @RequestMapping("select")
    public String select(String uid,String sectorid,String nianling,String xuanze,String neirong,Model model,String permissions,String pages){
        int count = personService.getcount(uid,sectorid,nianling,xuanze,neirong);
        model.addAttribute("counts",count);
        int a = 0;
        if (count%10==0){
            count = count/10;
        }else {
            count = count/10+1;
        }
        if (!Objects.equals(pages, "") && pages != null){
            a = Integer.parseInt(pages);
            if (a>=count){
                pages = String.valueOf(count);
            }else if (a<=0){
                pages = String.valueOf(1);
            }
        }else {
            pages = String.valueOf(1);
        }
        List<Ps> persons = personService.select(uid,sectorid,nianling,xuanze,neirong,pages);
        List<sector> sectors = sectorservice.list();
        model.addAttribute("count",count);
        model.addAttribute("sectors",sectors);
        model.addAttribute("persons",persons);
        model.addAttribute("sectorid",sectorid);
        model.addAttribute("nianling",nianling);
        model.addAttribute("xuanze",xuanze);
        model.addAttribute("neirong",neirong);
        model.addAttribute("pages",pages);
        model.addAttribute("uid",uid);
        switch (permissions){
            case "系统管理员":
                return "personlist01";
            case "管理员":
                return "personlist02";
            default:
                return "personlist03";
        }

    }

    /*
    * 删除人员信息
    * */
    @RequestMapping("delete")
    public String delete01(Integer id, String  permissions,
                           RedirectAttributes attr,String uid,
                           String sectorid,String nianling,String xuanze,
                           String neirong,String pages){
        //1.根据id删除员工信息
        personService.delete(id);
        //2.跳转到列表页面
        attr.addAttribute("permissions",permissions);
        attr.addAttribute("uid",uid);
        attr.addAttribute("sectorid",sectorid);
        attr.addAttribute("nianling",nianling);
        attr.addAttribute("xuanze",xuanze);
        attr.addAttribute("neirong",neirong);
        attr.addAttribute("pages",pages);

        return "redirect:/person/select";
        }


    /*
    * 更新
    * */
    @RequestMapping("updateperson")
    public String update(Person person,String permissions,RedirectAttributes attr,
                         String uid, String sectorid,String nianling,String xuanze,
                         String neirong,String pages){
        System.out.println(person);
        personService.updateperson(person);
        attr.addAttribute("permissions",permissions);
        attr.addAttribute("pages",pages);
        attr.addAttribute("uid",uid);
        attr.addAttribute("sectorid",sectorid);
        attr.addAttribute("nianling",nianling);
        attr.addAttribute("xuanze",xuanze);
        attr.addAttribute("neirong",neirong);

        return "redirect:/person/select";
    }
    /*
    *
    * 按id查找
    * */
    @RequestMapping("selectbyid")
    public String selectbyid(Integer id,Model model,String permissions,String uid, String sectorid,String nianling,String xuanze,
                             String neirong,String pages){
        Person person = personService.findpersonbyid(id);
        List<sector> sectors = sectorservice.list();

        model.addAttribute("person",person);
        model.addAttribute("sectors",sectors);
        model.addAttribute("pages",pages);
        model.addAttribute("uid",uid);
        model.addAttribute("sectorid",sectorid);
        model.addAttribute("nianling",nianling);
        model.addAttribute("xuanze",xuanze);
        model.addAttribute("neirong",neirong);
        switch (permissions){
            case "系统管理员":
                return "updateperson";
            default:
                return "updateperson02";
        }
    }
    /*
    * 添加人员
    */
    @RequestMapping("addperson01")
    public String addperson01(Person person,String permissions,RedirectAttributes attr,String uid, String sectorid,String nianling,String xuanze,
                              String neirong,String pages){
        personService.addperson(person);
        attr.addAttribute("permissions",permissions);
        attr.addAttribute("pages",pages);
        attr.addAttribute("uid",uid);
        attr.addAttribute("sectorid",sectorid);
        attr.addAttribute("nianling",nianling);
        attr.addAttribute("xuanze",xuanze);
        attr.addAttribute("neirong",neirong);
        return "redirect:/person/select";
    }
}
