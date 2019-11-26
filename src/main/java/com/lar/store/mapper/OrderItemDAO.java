package com.lar.store.mapper;

import com.lar.store.pojo.Order;
import com.lar.store.pojo.OrderItem;
import com.lar.store.pojo.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface OrderItemDAO extends JpaRepository<OrderItem,Integer> {

    public List<OrderItem>  findAllByUidEqualsAndStatusEquals(int id,int status);//找到该用户的所有订单项
    public List<OrderItem> findAll();
    public List<OrderItem> findAllByUid(int uid);
}
