package com.lar.store.mapper;

import com.lar.store.pojo.Category;
import com.lar.store.pojo.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product,Integer> {
//        public List<Product> findAllByCategoryOrderByIdDesc(int cid);
        public List<Product> findAllById(int cid);
        Page<Product> findByCategory(Category category, Pageable pageable);
}
