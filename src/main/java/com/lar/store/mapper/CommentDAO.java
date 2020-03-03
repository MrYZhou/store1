package com.lar.store.mapper;

import com.lar.store.pojo.Product;
import com.lar.store.pojo.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentDAO extends JpaRepository<Review,Integer> {

    List<Review> findAllByProductEquals(Product product);
    Page findAllByProductEquals(Product product, PageRequest pageable);
}
