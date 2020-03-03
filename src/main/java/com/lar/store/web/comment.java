package com.lar.store.web;

import com.lar.store.pojo.Category;
import com.lar.store.pojo.OrderItem;
import com.lar.store.pojo.Review;
import com.lar.store.service.CommentService;
import com.lar.store.service.OrderItemService;
import com.lar.store.service.ProductService;
import com.lar.store.service.ReviewService;
import com.lar.store.util.MyTime;
import com.lar.store.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
public class comment {
    @Autowired
    ReviewService reviewService;
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    CommentService commentService;
    @Autowired
    ProductService productService;
    @GetMapping("comment")
    public List<Review> getProductComment(@RequestParam(value="pid")int pid){
        return  commentService.findAllCommentByPid(pid);
    }

    @PostMapping("comment")
    public String addcomment(@RequestBody Review review) throws ParseException {
        review.setCreatedate(MyTime.getTime());
        reviewService.saveReview(review);
        OrderItem orderItem=orderItemService.getOrderItem(review.getOid());
        orderItem.setStatus(3);
        orderItemService.change_order_status(orderItem);
//        System.out.println("-------------------"+review);
        return "1";
    }

}
