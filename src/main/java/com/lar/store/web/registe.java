package com.lar.store.web;

import com.lar.store.pojo.User;
import com.lar.store.service.impl.RegisteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class registe {
    @Autowired
    RegisteServiceImpl registeServiceImpl;
    @RequestMapping(value = "/registePage",method = RequestMethod.GET)
    public ModelAndView registePage(){

        ModelAndView modelAndView=new ModelAndView("registe");
        return modelAndView;
    }
    @RequestMapping(value = "/registe",method = RequestMethod.POST)
    public String doregiste(User user){
        //
        System.out.println(user);
        return "";
    }
    @RequestMapping(value = "/checkAccount",method = RequestMethod.GET)
    public String account_check(){
        //
        return "";
    }
}
