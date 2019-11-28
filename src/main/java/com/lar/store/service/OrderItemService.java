package com.lar.store.service;

import com.lar.store.mapper.OrderDAO;
import com.lar.store.mapper.OrderItemDAO;
import com.lar.store.pojo.OrderItem;
import com.lar.store.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {
    @Autowired
    OrderItemDAO orderItemDAO;
    public void addOrderItem(OrderItem orderItem){
        orderItemDAO.save(orderItem);
    }
    public List<OrderItem> findALL(){
       return orderItemDAO.findAll();
    }
    public List<OrderItem> findAllUserOrders(int uid,int status){
        return orderItemDAO.findAllByUidEqualsAndStatusEquals(uid,status);
    }
    public  void deleteBean(int id){
        orderItemDAO.deleteById(id);
    }
    public Page4Navigator<OrderItem> list(int start, int size, int navigatePages) {
        PageRequest pageable=PageRequest.of(start,size, Sort.Direction.DESC, "id");
        Page pageFromJPA =orderItemDAO.findAll(pageable);//返回分页对象
        return new Page4Navigator<>(pageFromJPA,navigatePages);//分页对象在封装
    }
    //获取一个orderitem的对象
    public OrderItem getOrderItem(int id){
        return orderItemDAO.getOne(id);
    }
    //更改订单
    public String change_order_status(OrderItem orderItem){
        orderItemDAO.save(orderItem);
        return "1";
    }
}
