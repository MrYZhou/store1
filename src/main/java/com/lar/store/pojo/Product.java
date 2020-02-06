package com.lar.store.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="product")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer"})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String goodsname;
    private float price;
    private int stock;
    private Date createDate;
    private  int salenum;

    public int getSalenum() {
        return salenum;
    }

    public void setSalenum(int salenum) {
        this.salenum = salenum;
    }

    //给当前表增加一个cid外键
    @ManyToOne
    @JoinColumn(name="cid",foreignKey = @ForeignKey(name = "none",value = ConstraintMode.NO_CONSTRAINT))
    private Category category;

    public Product() {
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", goodsname='" + goodsname + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", createDate=" + createDate +
                ", salenum=" + salenum +
                ", category=" + category +
                '}';
    }
}
