package com.lar.store.mapper;

import com.lar.store.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
        public User login(String account);
}
