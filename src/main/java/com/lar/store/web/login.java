package com.lar.store.web;

import com.lar.store.pojo.Status;
import com.lar.store.pojo.User;
import com.lar.store.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
public class login {
    @Autowired
    LoginService loginService;

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public User dologin(@RequestBody User user,HttpSession httpSession){
        //进行登录
        System.out.println("进行登录------"+user);

        if(user.getAccount()!=null){
            String pwd=loginService.get_pwd(user.getAccount());
            if(pwd.equals(user.getPwd())){
                System.out.println("存入session");
                httpSession.setAttribute("name",loginService.getUser(user.getAccount()));
                return user;
            }else{
                return null;//登录页面
            }
        }
        return null;
    }
    @GetMapping(value = "logout")
    public  ModelAndView logout(HttpSession httpSession){
        httpSession.removeAttribute("name");
        return new ModelAndView("redirect:/");
    }
    @PostMapping(value = "logincheck")
    public  String check(@RequestParam(value = "account")String account, HttpSession httpSession){
        //System.out.println(account);

        if(loginService.checkAccount(account)){
            System.out.println("找到");

            return "0";
        }
        System.out.println("没找到");
        return "1";
    }
}
