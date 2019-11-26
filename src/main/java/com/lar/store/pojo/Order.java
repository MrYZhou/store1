package com.lar.store.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "order_")

@JsonIgnoreProperties({ "handler","hibernateLazyInitializer"})
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @OneToOne
    @JoinColumn(name = "uid")
    User user;
    @Transient
    List<OrderItem> orderitem;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public List<OrderItem> getOrderitem() {
        return orderitem;
    }

    public void setOrderitem(List<OrderItem> orderitem) {
        this.orderitem = orderitem;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", orderitem=" + orderitem +
                '}';
    }
}
