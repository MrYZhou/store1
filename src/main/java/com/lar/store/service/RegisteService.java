package com.lar.store.service;

import com.lar.store.mapper.UserMapper;
import com.lar.store.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisteService {
    @Autowired
    UserMapper registeMapper;

    public int addAccount(User user) {
        registeMapper.save(user);
        return 1;
    }
    public boolean checkAccount(String account){
        User u=registeMapper.findUserByAccount(account);
        if(u==null){
            return  false;
        }
        return  true;//true代表有
    }
}
