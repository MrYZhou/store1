package com.lar.store.service.impl;

import com.lar.store.mapper.LoginMapper;
import com.lar.store.pojo.User;
import com.lar.store.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginMapper loginMapper;


    @Override
    public String get_pwd(String account) {
      User u=loginMapper.login(account);
      if(u==null){
          return "0";
      }
      return u.getPwd();
    }
}
