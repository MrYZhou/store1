package com.lar.store.mapper;

import com.lar.store.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserMapper extends JpaRepository<User,Integer> {
    public  User findUserByAccount(String account);
}
