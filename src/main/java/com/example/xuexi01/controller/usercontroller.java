package com.example.xuexi01.controller;

import com.example.xuexi01.entity.u;
import com.example.xuexi01.entity.user;
import com.example.xuexi01.service.userservice;
import com.example.xuexi01.utils.VerifyCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

@Controller
@RequestMapping("user")
public class usercontroller {

    private userservice userservice;

    @Autowired
    public usercontroller(com.example.xuexi01.service.userservice userservice) {
        this.userservice = userservice;
    }




    @RequestMapping("select")
    public String select(Model model,String userpermissions,String xuanze,String neirong,String id){
        List<user> users = userservice.userselect(userpermissions,xuanze,neirong,id);
        model.addAttribute("users",users);
        List<u> upermissions = userservice.upermissions();
        model.addAttribute("upermissions",upermissions);
        model.addAttribute("userpermissions",userpermissions);
        model.addAttribute("xuanze",xuanze);
        model.addAttribute("neirong",neirong);
        model.addAttribute("id",id);
        return "userlist";
    }

    /*
     * 系统管理员删除人员信息
     * */
    @RequestMapping("/delete")
    public String delete(Integer uid){
        System.out.println(uid);
        //1.根据id删除员工信息
        userservice.delete(uid);
        //2.跳转到列表页面
        return "redirect:/user/list";
    }
    /*
     * 管理员更新
     * */
    @RequestMapping("/updateuser")
    public String update02(user user){
        userservice.updateuser(user);
        return "redirect:/user/list";
    }

    /*
     *
     * 按id查找
     * */
    @RequestMapping("selectbyuid")
    public String selectbyuid(Integer uid,Model model){
        user user = userservice.finduserbyid(uid);
        model.addAttribute("user",user);
        return "updateuser";
    }

    /*
    * 用户列表
    * */
    @RequestMapping("/list")
    public String listEmployee(Model model) {
        //1.获取员工列表
        List<user> users = userservice.list();
        //request.setAttribute("user",user);
        model.addAttribute("users", users);
        List<u> upermissions = userservice.upermissions();
        model.addAttribute("upermissions",upermissions);
        return "userlist";
    }
    /*
    * 用户登录
    * */
    @RequestMapping("/login")
    public String login(String code,String uname,String password,HttpSession session) throws UnsupportedEncodingException {
        user user = new user();
        try {
            //1.比较验证码
            String sessionCode = session.getAttribute("code").toString();
            if (!sessionCode.equalsIgnoreCase(code)) throw new RuntimeException("验证码输入错误！");
            //2.执行登录业务逻辑
            user = userservice.login(uname,password);
            //3.登录成功,保存用户登录标记
            session.setAttribute("user",user);
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/login.jsp?msg=" + URLEncoder.encode(e.getMessage(), "UTF-8");
        }
        switch (user.getPermissions()){
            case "系统管理员":
                return "redirect:/admin01.jsp";
            case "管理员":
                return "redirect:/admin02.jsp";
            default:
                return "redirect:/admin03.jsp";
        }

    }
    /*
    * 用户注册
    *
    * */
    @RequestMapping("/regist")
    public String regist(user user,String code,HttpSession session) throws UnsupportedEncodingException {
        try {
            //1.比较验证码
            String sessionCode = session.getAttribute("code").toString();
            if (!sessionCode.equalsIgnoreCase(code)) throw new RuntimeException("验证码输入错误！");
            //2.注册用户
            userservice.regist(user);
        }catch (RuntimeException e){
            e.printStackTrace();
            return "redirect:/regist.jsp?msg="+ URLEncoder.encode(e.getMessage(),"UTF-8");

        }
        return "redirect:/login.jsp";
    }
    /*
     *
     * 验证码生成
     *
     * */
    @RequestMapping("/captcha")
    public void generateImageCode(HttpSession session, HttpServletResponse response) throws IOException, IOException {
        //1.生成随机字符串
        String code = VerifyCodeUtils.generateVerifyCode(4);
        //2.保存随机字符串到Session中
        session.setAttribute("code",code);
        //3.将随机字符串生成图片
        //4.通过response响应图片
        response.setContentType("image/png");//指定响应类型
        ServletOutputStream os = response.getOutputStream();
        VerifyCodeUtils.outputImage(120,40,os,code);
    }
}
