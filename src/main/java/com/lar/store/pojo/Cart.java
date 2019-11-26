package com.lar.store.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.lar.store.web.product;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "cart")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer"})
public class Cart {
    //购物车的数据，是用于填充给购物车页面

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int uid;
    int buynum;
    float subprice;

    public float getSubprice() {
        return subprice;
    }

    public void setSubprice(float subprice) {
        this.subprice = subprice;
    }

    //    int pid;
    @OneToOne
    @JoinColumn(name = "pid")
    Product product;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getBuynum() {
        return buynum;
    }

    public void setBuynum(int buynum) {
        this.buynum = buynum;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", uid=" + uid +
                ", buynum=" + buynum +
                ", subprice=" + subprice +
                ", product=" + product +
                '}';
    }
}
