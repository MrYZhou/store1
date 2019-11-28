package com.lar.store.service;

import com.lar.store.mapper.UserMapper;
import com.lar.store.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    UserMapper userMapper;
    public String getUserName(int id){
        return userMapper.getOne(id).getAccount();
    }
    //判断登录用户是否存在
    public boolean checkAccount(String a) {
        User u=userMapper.findUserByAccount(a);
        if(u==null){
            return false;
        }else{
            return true;
        }
    }
    //获取用户对象
    public User getUser(String a) {
        return userMapper.findUserByAccount(a);
    }
    //获取登录的用户密码
    public String get_pwd(String a) {
        User u=userMapper.findUserByAccount(a);
        return u.getPwd();
    }

}
