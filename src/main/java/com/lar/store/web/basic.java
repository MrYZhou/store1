package com.lar.store.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.Contended;

@RestController
public class basic {
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView mv=new ModelAndView("index");
        return mv;
    }
    @RequestMapping("/hello")
    public String hello()
    {
        return "hll";
    }
}
