package com.lar.store.web;

import com.lar.store.pojo.User;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

@Controller
public class frontController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String goindex(){
        return "/index";
    }
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public ModelAndView index(HttpSession httpSession){
        User u= (User) httpSession.getAttribute("name");
        System.out.println("httpsession中的user"+u);
        ModelAndView mv=new ModelAndView("index");
        if(u==null){
           //mv.addObject("name","");
        }else{
            System.out.println("填充");
            mv.addObject("name",u);
        }
        return mv;
    }

    @RequestMapping(value = "/registePage",method = RequestMethod.GET)
    public ModelAndView registePage(){
        ModelAndView modelAndView=new ModelAndView("registe");
        return modelAndView;
    }

    @RequestMapping(value = "/loginPage",method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView mv=new ModelAndView("login");
        return mv;
    }


    @RequestMapping(value = "/personPage",method = RequestMethod.GET)
    public ModelAndView personpage(HttpSession httpSession){
        //这里直接通过id进入个人空间，后期可以通过判断user的id，是不是更请求的匹配
        User u= (User) httpSession.getAttribute("name");
        ModelAndView mv=new ModelAndView("mine");
        if(u==null){
        }else{
            System.out.println("填充");
            mv.addObject("name",u);
        }
        return mv;
    }

//    详情页
    @GetMapping("/detail")
    public ModelAndView detail(HttpSession httpSession){
        User u= (User) httpSession.getAttribute("name");
        ModelAndView mv=new ModelAndView("detail");
        if(u==null){
            //mv.addObject("name","");
        }else{
            mv.addObject("name",u);
        }
        return mv;
    }

    //order页面
    @GetMapping("/buyPage")
    public  ModelAndView buyPage(HttpSession httpSession){
        User u= (User) httpSession.getAttribute("name");
        ModelAndView mv=new ModelAndView("order");
        if(u==null){
            //mv.addObject("name","");
        }else{
            mv.addObject("name",u);
        }
        return mv;
    }
    //cartpage页面
    @GetMapping("/cartPage")
    public ModelAndView cartPage(){
        return new ModelAndView("cart");
    }

    //订单成功页面
    @GetMapping("orderSuccess")
    public ModelAndView orderSuccessPage(){
        return new ModelAndView("orderSuccess");
    }



}
