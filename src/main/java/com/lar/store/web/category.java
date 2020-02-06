package com.lar.store.web;

import com.lar.store.pojo.Category;
import com.lar.store.pojo.Product;
import com.lar.store.service.CategoryService;
import com.lar.store.service.ProductService;
import com.lar.store.util.ImageUtil;
import com.lar.store.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class category {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @GetMapping("/categories")
    public Page4Navigator<Category> list(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start<0?0:start;
        Page4Navigator<Category> page =categoryService.list(start, size, 5);  //5表示导航分页最多有5个，像 [1,2,3,4,5] 这样
        return page;
    }
    @GetMapping("/listcategory")
    public List<Category> listCategory(){
        return  categoryService.getAllCategories();
    }

    @PostMapping("/categories")
    public Object add(Category bean, MultipartFile image, HttpServletRequest request) throws Exception {
        categoryService.add(bean);
        saveOrUpdateImageFile(bean, image, request);
        return bean;
    }
    public void saveOrUpdateImageFile(Category bean, MultipartFile image, HttpServletRequest request)
            throws IOException {
        String uri= ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static/img/category";
      //  System.out.println("图片保存路径"+uri);
        File imageFolder= new File(uri);
        File file = new File(imageFolder,bean.getId()+".jpg");
        if(!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        image.transferTo(file);
        BufferedImage img = ImageUtil.change2jpg(file);
        ImageIO.write(img, "jpg", file);
    }

    //删除一个对象
    @DeleteMapping("/categories/{id}")
    public String delete(@PathVariable("id") int id, HttpServletRequest request)  throws Exception {

        List<Product> products=productService.getAllProductByCid(id);
        for (Product product:products){
            if(0<product.getId()){
                productService.deleteBean(product.getId());
            }

        }
        categoryService.deleteBean(id);
        return null;
    }

    @GetMapping("/categories/{id}")
    public Category get(@PathVariable("id") int id) throws Exception {
        Category bean=categoryService.get(id);
        return bean;
    }
    //获取分类id
    @GetMapping("category")
    public int getCategoryId(@RequestParam("name")String name){
        return categoryService.getCategoryId(name).getId();
    }
    @PutMapping("/categories/{id}")
    public Object update(Category bean, MultipartFile image,HttpServletRequest request) throws Exception {
        String name = request.getParameter("name");
        bean.setName(name);
        categoryService.update(bean);

        if(image!=null) {
            saveOrUpdateImageFile(bean, image, request);
        }
        return bean;
    }
}
