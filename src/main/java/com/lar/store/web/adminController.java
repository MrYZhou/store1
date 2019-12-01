package com.lar.store.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class adminController {
    //初始页面，显示分类管理
    @RequestMapping(value = "/admin")
    public String adminPage(){
        return "admin";
    }

    //跳转链接，编辑分类管理
    @GetMapping(value="/admin_category_edit")
    public String editCategory(){
        return "editCategory";

    }
    //跳转链接，分类商品相关
    @GetMapping(value="/admin_product_list")
    public String listProduct(){
        return "listProduct";

    }
    //跳转链接，分类商品相关
    @GetMapping(value="/admin_product_edit")
    public String editProduct(){
        return "editProduct";
    }

    @GetMapping(value = "/admin_order_list")
    public String order_list(){
        return "listOrder";
    }

    @GetMapping(value = "orders_detail")
    public String orders_detail(){
        return  "orders_detail";
    }

    //跳转链接，property
    @RequestMapping(value = "/admin_propertyValue_edit")
    public String adminPropertyPage(){
        return "property_list";
    }
}
