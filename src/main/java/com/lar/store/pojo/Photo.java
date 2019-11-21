package com.lar.store.pojo;

import javax.persistence.*;

@Entity
@Table(name = "photo")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String smallUri;
    private String bigUri;
    @ManyToOne
    @JoinColumn(name="pid")
    Product product;
    public Photo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSmallUri() {
        return smallUri;
    }

    public void setSmallUri(String smallUri) {
        this.smallUri = smallUri;
    }

    public String getBigUri() {
        return bigUri;
    }

    public void setBigUri(String bigUri) {
        this.bigUri = bigUri;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
