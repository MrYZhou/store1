package com.lar.store.web;

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
    public ModelAndView registe(){

        ModelAndView mv=new ModelAndView("registe");
        return mv;
    }
    @RequestMapping(value = "/registe",method = RequestMethod.POST)
    public String doregiste(){


        return "";
    }
}
