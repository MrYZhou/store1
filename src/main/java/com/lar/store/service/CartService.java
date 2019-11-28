package com.lar.store.service;

import com.lar.store.mapper.CartDAO;
import com.lar.store.pojo.Cart;
import com.lar.store.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    CartDAO cartDAO;
    public void deleteBean(Cart cart){
        cartDAO.delete(cart);
    }
    public Cart getCart(int id){
        return cartDAO.getOne(id);
    }
    public List<Cart> getCartProducts(int uid){
        List<Cart> products=cartDAO.findAllByUidEquals(uid);
        return  products;
    }
    public Cart getCartByUidAndProduct(int uid, Product product){
        Cart cart=cartDAO.getByUidEqualsAndProductEquals(uid,product);
        return cart;
    }
    public  void saveCart(Cart cart){
        cartDAO.save(cart);
    }
}
