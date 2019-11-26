package com.lar.store.web;

import com.lar.store.pojo.Cart;
import com.lar.store.pojo.Info;
import com.lar.store.pojo.OrderItem;
import com.lar.store.service.InfoService;
import com.lar.store.service.OrderItemService;
import com.lar.store.util.Page4Navigator;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class order {
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    InfoService infoService;
    @PostMapping("/info")
    private int order_info(@RequestBody OrderItem orderItem){
        //这里的话需要存入orderitem.和info表
        Info info=orderItem.getInfo();
        infoService.addInfo(info);
        orderItemService.addOrderItem(orderItem);
        return 1;
    }

    @PostMapping("/orders")
    private int orders(@RequestBody OrderItem orderItem){
        System.out.println("ok");
        //这里的话需要存入orderitem.和info表
        Info info=orderItem.getInfo();
        infoService.addInfo(info);
        orderItemService.addOrderItem(orderItem);
        return 1;
    }

    @GetMapping("/orders/{uid}/{status}")
    public List<OrderItem> getUserOrders(@PathVariable(value = "uid") int uid,@PathVariable (value = "status")int status){
        List<OrderItem> orderItems=orderItemService.findAllUserOrders(uid,status);
        return orderItems;
    }

    @GetMapping("/orders")
    public Page4Navigator<OrderItem> list(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start<0?0:start;
        Page4Navigator<OrderItem> page =orderItemService.list(start, size, 5);  //5表示导航分页最多有5个，像 [1,2,3,4,5] 这样
        return page;
    }

    //处理订单，将status属性变成2，代表已经发货。
    @DeleteMapping("/orders/{oid}")
    public String delete_order(@PathVariable(value = "oid") int oid){
        OrderItem orderItem=orderItemService.getOrderItem(oid);
        orderItem.setStatus(2);
        orderItemService.change_order_status(orderItem);
        return "1";
    }
}
