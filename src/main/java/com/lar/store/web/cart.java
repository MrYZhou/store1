package com.lar.store.web;

import com.lar.store.pojo.Cart;
import com.lar.store.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class cart {
    @Autowired
    CartService cartService;

    @GetMapping("/carts/{uid}")
    public List<Cart> getCarts(@PathVariable(value = "uid")int uid){
        System.out.println("ok");
        List<Cart> obj=cartService.getCartProducts(uid);
        return  obj;
    }
    @PostMapping("/carts")
    public void addCart(@RequestBody Cart cart){
        //是否存在
        System.out.println("是否存在:"+cart);
        Cart cart1=cartService.getCartByUidAndProduct(cart.getUid(),cart.getProduct());
        if(cart1!=null){
            cart1.setBuynum(cart1.getBuynum()+cart.getBuynum());
            cartService.saveCart(cart1);
        }else {
            cartService.saveCart(cart);
        }
    }

}
