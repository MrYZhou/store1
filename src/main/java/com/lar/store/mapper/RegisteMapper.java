package com.lar.store.mapper;

import com.lar.store.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegisteMapper {
        public int add(User user);
}
