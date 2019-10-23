package com.lar.store.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class login {
    @RequestMapping(value = "/loginPage",method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView mv=new ModelAndView("login");
        return mv;
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String dologin(){
        //进行登录

        return "";
    }
}
