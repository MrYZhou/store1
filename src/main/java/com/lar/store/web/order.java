package com.lar.store.web;

import com.lar.store.pojo.Cart;
import com.lar.store.pojo.Info;
import com.lar.store.pojo.OrderItem;
import com.lar.store.pojo.Product;
import com.lar.store.service.CartService;
import com.lar.store.service.InfoService;
import com.lar.store.service.OrderItemService;
import com.lar.store.service.ProductService;
import com.lar.store.util.MyTime;
import com.lar.store.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.util.List;

@RestController
public class order {
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    InfoService infoService;
    @Autowired
    CartService cartService;
    @Autowired
    ProductService productService;
    @PostMapping("/info")
    private int order_info(@RequestBody OrderItem orderItem){
        //这里的话需要存入orderitem.和info表
        Info info=orderItem.getInfo();
        infoService.addInfo(info);

        orderItemService.addOrderItem(orderItem);
        return 1;
    }

    @PostMapping("/orders")
    private int orders(@RequestBody OrderItem orderItem) throws ParseException {
        //这里的话需要存入orderitem.和info表,并删除cart的buynum记录
        Info info=orderItem.getInfo();
        infoService.addInfo(info);
        orderItemService.addOrderItem(orderItem);
        System.out.println("product数据："+orderItem.getProduct());
        Cart cart=cartService.getCartByUidAndProduct(orderItem.getUid(),orderItem.getProduct());
        int num=cart.getBuynum()-orderItem.getBuynum();
        System.out.println("cart的商品数量："+num);

        System.out.println("时间"+MyTime.getTime());
        orderItem.setCreateDate(MyTime.getTime());
        if(num==0){
            cartService.deleteBean(cart);
        }else{
            cart.setBuynum(num);
            cartService.saveCart(cart);
        }

        return 1;
    }
    //获取用户对应的status列表
    @GetMapping("/orders/{uid}/{status}")
    public List<OrderItem> getUserOrders(@PathVariable(value = "uid") int uid,@PathVariable (value = "status")int status){
        List<OrderItem> orderItems=orderItemService.findAllUserOrders(uid,status);
        return orderItems;
    }
    //获取订单分页，后台使用
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
        //同时由于已经是收货的状态，所以我们还需要更改货品的salenum字段才可以,
        //首选需要获取到要更改的product
        int pid=orderItem.getProduct().getId();
        Product product=productService.getProductById(pid);
                product.setSalenum(product.getSalenum()+1);
        productService.add(product);
        return "1";
    }
}
