package com.lar.store.web;

import com.lar.store.pojo.User;
import com.lar.store.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class login {
    @Autowired
    LoginService loginService;
    @RequestMapping(value = "cookie",method = RequestMethod.GET)
    public User cookie_login( @CookieValue(name = "account")String account, @CookieValue(name = "pwd")String password){
        if(account!=null && password!=null){
            System.out.println("通过cookie");
            return loginService.getUserByAccountAndPwd(account,password);
        }else {
            return null;
        }
    }
    @RequestMapping(value = "useraccount",method = RequestMethod.GET)
    public String findUserById(@RequestParam(name="id")int id){
        return loginService.getUserName(id);
    }
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public User dologin(HttpServletResponse httpServletResponse, @RequestBody User user, HttpSession httpSession){
        //进行登录
//        System.out.println("进行登录------"+user);

            if(user.getAccount()!=null){
                String pwd=loginService.get_pwd(user.getAccount());
                if(pwd.equals(user.getPwd())){
                    httpSession.setAttribute("name",loginService.getUser(user.getAccount()));
                    Cookie cookie=new Cookie("account",user.getAccount());
                    cookie.setMaxAge(24*60*7*60);
                    httpServletResponse.addCookie(cookie);
                    cookie=new Cookie("pwd",user.getPwd());
                    cookie.setMaxAge(24*60*7*60);
                    httpServletResponse.addCookie(cookie);
                    return user;
                }else{
                    return null;//登录页面
                }
            }




        return null;
    }
    @GetMapping("username")
    public String getUserName(@RequestParam(value = "uid")int uid){
        return loginService.getUserName(uid);
    }
    @GetMapping(value = "logout")
    public  ModelAndView logout(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,HttpSession httpSession, @CookieValue(name = "account")String account, @CookieValue(name = "pwd")String password){
        httpSession.invalidate();//使session无效
        Cookie[] cookies=httpServletRequest.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            cookies[i].setMaxAge(0);
            httpServletResponse.addCookie(cookies[i]);
        }
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
