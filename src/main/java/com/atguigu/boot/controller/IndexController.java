package com.atguigu.boot.controller;

import com.atguigu.boot.bean.U;
import com.atguigu.boot.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @GetMapping({"/","/login"})
    public String login(){
        return "login";
    }



    @PostMapping("/login")
    public String main(U user, HttpSession session, Model model){
        if(!StringUtils.isEmpty(user.getUserName())&& StringUtils.hasLength(user.getPassWord())){
            session.setAttribute("user",user);
            return "redirect:/main";
        }
        model.addAttribute("msg","请填写账号或者账号错误");
        return "login";
    }



    @GetMapping("main")
    public String mainPage(){
        return "main";
    }


}
