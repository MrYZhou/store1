package com.lar.store.mapper;

import com.lar.store.pojo.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewDao extends JpaRepository<Review,Integer> {
}
