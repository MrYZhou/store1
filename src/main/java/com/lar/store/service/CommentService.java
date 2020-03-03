package com.lar.store.service;

import com.lar.store.mapper.CommentDAO;
import com.lar.store.pojo.Category;
import com.lar.store.pojo.Product;
import com.lar.store.pojo.Review;
import com.lar.store.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentDAO commentDAO;
    @Autowired
    ProductService productService;
    //该方法有待完善
    public Page4Navigator<Review> list(int start, int size, int navigatePages, Product product) {
        PageRequest pageable=PageRequest.of(start,size, Sort.Direction.DESC, "id");
        Page pageFromJPA =commentDAO.findAllByProductEquals(product,pageable);//返回分页对象
        System.out.println("pageFromJPA"+pageFromJPA.getTotalElements());
        return new Page4Navigator<>(pageFromJPA,navigatePages);//分页对象在封装
    }
    public List<Review> findAllCommentByPid(int id){
        return commentDAO.findAllByProductEquals(productService.getProductById(id));
    }
}
