package com.lar.store.web;

import com.lar.store.pojo.Property;
import com.lar.store.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class property {
    @Autowired
    PropertyService propertyService;
    @PostMapping("property")
    public void addProperty(@RequestBody Property property){
        propertyService.addProperty(property);
    }
    @GetMapping("property/{id}")
    public List<Property> getProductProperties(@PathVariable int id){
        return propertyService.getPropertyByPid(id);
    }

}
