package com.lar.store.service.impl;

import com.lar.store.mapper.RegisteMapper;
import com.lar.store.service.RegisteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisteServiceImpl implements RegisteService {
    @Autowired
    RegisteMapper registeMapper;

    @Override
    public int addAccount() {
        return registeMapper.add();
    }
}
