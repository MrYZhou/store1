package com.lar.store.service;

import com.lar.store.mapper.ProductDAO;
import com.lar.store.mapper.PropertyDAO;
import com.lar.store.pojo.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {
    @Autowired
    PropertyDAO propertyDAO;
    public void addProperty(Property property){
        propertyDAO.save(property);
    }
    public List<Property> getPropertyByPid(int id){
        return propertyDAO.getAllByPidEquals(id);
    }
}
