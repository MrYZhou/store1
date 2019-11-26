package com.lar.store.service;

import com.lar.store.mapper.ProductDAO;
import com.lar.store.pojo.Category;
import com.lar.store.pojo.Product;
import com.lar.store.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;

import java.io.File;

@Service
public class ProductService {
    @Autowired
    ProductDAO productDAO;
    @Autowired
    CategoryService categoryService;
    //查询商品
    public Page4Navigator<Product> list(int cid, int start, int size, int navigatePages) {
        Category category = categoryService.get(cid);
        Pageable pageable =PageRequest.of(start,size,Sort.Direction.DESC, "id");
        Page<Product> pageFromJPA =productDAO.findByCategory(category,pageable);
        return new Page4Navigator<>(pageFromJPA,navigatePages);
    }
    //添加商品
    public void add(Product bean) {
        productDAO.save(bean);
    }

    //删除商品
    public void deleteBean(int id){
        productDAO.deleteById(id);
        String uri= ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static/img/product";
        File imageFolder= new File(uri);
        File file = new File(imageFolder,id+".jpg");
        file.delete();
    }

    public Product get(int id) {
        return productDAO.getOne(id);
    }
    //更改商品

}
