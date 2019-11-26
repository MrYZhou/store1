package com.lar.store.mapper;

import com.lar.store.pojo.Cart;
import com.lar.store.pojo.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartDAO extends JpaRepository<Cart,Integer> {

    Cart getByUidEqualsAndProductEquals(int uid, Product product);
    List<Cart> findAllByUidEquals(int id);

}
