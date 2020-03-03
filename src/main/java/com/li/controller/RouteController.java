package com.li.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RouteController {

    @RequestMapping({"/","/index"})
    public String index(){
        return "index";
    }

    @RequestMapping("toLogin")
    public String toLogin(){
        return "views/login";
    }

    //注销账号
    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "views/login";
    }


    @RequestMapping("/login")
    public String Login(String name,String password,Model model){
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        //获取用户登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);

        try {
            subject.login(token);//执行登录的方法，如果没有异常登录成功

            return "index";
        }catch (UnknownAccountException e){
           model.addAttribute("msg","用户名错误");//用户名不存在
           return "views/login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误");//密码错误
            return "views/login";
        }

    }

    @RequestMapping("/authc")
    @ResponseBody
    public String nohc(){
        return "未授权请求页面！";
    }

    @RequestMapping("/level1/{id}")
    public String level1(@PathVariable("id")int id){
        return "views/level1/"+id;
    }
    @RequestMapping("/level2/{id}")
    public String level2(@PathVariable("id")int id){
        return "views/level2/"+id;
    }
    @RequestMapping("/level3/{id}")
    public String level3(@PathVariable("id")int id){
        return "views/level3/"+id;
    }
}
