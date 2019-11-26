package com.lar.store.service;

import com.lar.store.mapper.InfoDAO;
import com.lar.store.pojo.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoService {
    @Autowired
    InfoDAO infoDAO;
    public void addInfo(Info info){
        infoDAO.save(info);
    }
}
