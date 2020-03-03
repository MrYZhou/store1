package com.lar.store.service;

import com.lar.store.mapper.ReviewDao;
import com.lar.store.pojo.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    ReviewDao reviewDao;
    public void saveReview(Review review){
        reviewDao.save(review);
    }
}
