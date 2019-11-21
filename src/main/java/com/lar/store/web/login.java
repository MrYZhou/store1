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
    public ModelAndView dologin(User user,HttpSession httpSession){
        //进行登录
        System.out.println("------"+user);

        if(user.getAccount()!=null){
            String pwd=loginService.get_pwd(user.getAccount());

            if(pwd.equals(user.getPwd())){
                httpSession.setAttribute("name",loginService.getUser(user.getAccount()));


                return new ModelAndView("redirect:index");
            }else{
                return new ModelAndView("redirect:loginPage");
            }
        }
        return new ModelAndView("redirect:loginPage");
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
