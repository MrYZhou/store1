package com.lar.store.mapper;

import com.lar.store.pojo.Category;
import com.lar.store.pojo.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDAO extends JpaRepository<Category,Integer> {
        Category getCategoryByNameIsLike(String name);
}
