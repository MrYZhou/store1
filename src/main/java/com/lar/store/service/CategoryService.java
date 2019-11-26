package com.lar.store.service;

import com.lar.store.mapper.CategoryDAO;
import com.lar.store.pojo.Category;
import com.lar.store.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;

import java.io.File;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryDAO categoryDAO;
    public Page4Navigator<Category> list(int start, int size, int navigatePages) {
        PageRequest pageable=PageRequest.of(start,size,Sort.Direction.DESC, "id");
        Page pageFromJPA =categoryDAO.findAll(pageable);//返回分页对象
        return new Page4Navigator<>(pageFromJPA,navigatePages);//分页对象在封装
    }

    public void add(Category bean) {
    categoryDAO.save(bean);
}

    public  void  deleteBean(int id){
        categoryDAO.deleteById(id);
        String uri= ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static/img/category";
        File imageFolder= new File(uri);
        File file = new File(imageFolder,id+".jpg");
        file.delete();

    }

    public Category get(Integer id) {
        return categoryDAO.getOne(id);
    }
    public void update(Category bean) {
        categoryDAO.save(bean);
    }
}
