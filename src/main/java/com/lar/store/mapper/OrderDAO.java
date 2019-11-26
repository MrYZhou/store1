package com.lar.store.mapper;

import com.lar.store.pojo.Order;
import com.lar.store.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDAO extends JpaRepository<Order,Integer> {
    Order getByUser(User user);
}
