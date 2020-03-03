package com.lar.store.pojo;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@Table(name ="property")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int pid;
    String property_key;
    String property_value;

    public String getProperty_key() {
        return property_key;
    }

    public void setProperty_key(String property_key) {
        this.property_key = property_key;
    }

    public String getProperty_value() {
        return property_value;
    }

    public void setProperty_value(String property_value) {
        this.property_value = property_value;
    }

    public int getId() {
        return id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }


    public void setId(int id) {
        this.id = id;
    }


}
