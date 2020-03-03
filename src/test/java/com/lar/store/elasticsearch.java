package com.lar.store;

import com.lar.store.es.ProductResposity;
import com.lar.store.pojo.Category;
import com.lar.store.pojo.Product;
import com.lar.store.service.CategoryService;
import com.lar.store.service.ProductService;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class elasticsearch {
    @Autowired
    ProductResposity productResposity;
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    @Test
    public  void addProduct(){
       Product product2= productService.getProductById(21);
       productResposity.save(product2);
//        for (Product product : productResposity.findAll()) {
//            System.out.println(product.getCategory().getName());
//        }
    }
    @Test
    public void testelastic(){
        Pageable pageable = PageRequest.of(0,20) ;
        String name="i3-9100f";
//        Page<Product> page=  productResposity.findAllByGoodsnameContaining(name,pageable);
//        for (Product product : page.getContent()) {
//            System.out.println(product);
//        }
    }
    @Test
    public void testfindall(){
        Iterable iterable=productResposity.search(QueryBuilders.fuzzyQuery("goodsname","i3-9100f"));

        for (Product product:productResposity.search(QueryBuilders.fuzzyQuery("name","i3-9100f"))){
            System.out.println(product.getGoodsname());
        }

    }
}
