package com.lar.store.web;

import com.lar.store.pojo.Status;
import com.lar.store.pojo.User;
import com.lar.store.service.RegisteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class registe {
    @Autowired
    RegisteService registeService;

    @GetMapping(value = "registe")
    public  String registe(){
        return "registePage";
    }

    @RequestMapping(value = "registe",method = RequestMethod.POST)
    public ModelAndView doregiste(User user){
        System.out.println(user);
//        user.setInfokey(0);
        registeService.addAccount(user);
        return new ModelAndView("/login");

    }
    @GetMapping(value = "checkaccount")
    public  String check(@RequestParam(value = "account")String account){
        //System.out.println(account);
        if(registeService.checkAccount(account)){
            System.out.println("找到");
            return "1";
        }
        System.out.println("没找到");
        return "0";
    }


}
