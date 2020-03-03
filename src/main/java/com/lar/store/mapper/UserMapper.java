package com.lar.store.mapper;

import com.lar.store.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserMapper extends JpaRepository<User,Integer> {
    User findUserByAccount(String account);
    User findUserByAccountEqualsAndPwdEquals(String account, String pwd);
}
