package com.lar.store;

import com.lar.store.mapper.CartDAO;
import com.lar.store.mapper.OrderDAO;
import com.lar.store.mapper.OrderItemDAO;
import com.lar.store.pojo.*;
import com.lar.store.service.CartService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class test {
    @Autowired
    CartService cartService;
    @Autowired
    OrderItemDAO orderItemDAO;
    @Autowired
    OrderDAO orderDAO;
    @Autowired
    CartDAO cartDAO;
    @Before
    public void predivder(){
        System.out.println("*******************************");
    }
    @After
    public  void nextdivder(){
        System.out.println("*******************************");
    }
    @Test
    public void testgetCart(){
        List<Cart> obj=cartService.getCartProducts(13);
        if(obj!=null){
            for (int i = 0; i < obj.size(); i++) {
                System.out.println(obj.get(i));
            }
        }else {
            System.out.println("null");
        }
    }

    @Test
    public  void getOrders(){
        User u=new User();
        u.setId(1);
//        List<OrderItem> orderitems=orderItemDAO.findAllByUidEquals(1);
//        System.out.println(orderitems);
    }
    @Test
    public void testgetcart(){
        Product product=new Product();
        product.setId(13);
        Cart cart=cartDAO.getByUidEqualsAndProductEquals(1,product);
        System.out.println(cart);
    }

}
