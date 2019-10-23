package com.lar.store.web;

import com.lar.store.pojo.User;
import com.lar.store.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class login {
    @Autowired
    LoginServiceImpl loginService;
    @RequestMapping(value = "/loginPage",method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView mv=new ModelAndView("login");
        return mv;
    }
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String dologin(User user){
        //进行登录
        System.out.println(user);
        if(user.getAccount()!=null){
            String pwd=loginService.get_pwd(user.getAccount());
            System.out.println("密码是"+pwd);
        }else{
            return "2";
        }

        return "1";
    }
}
