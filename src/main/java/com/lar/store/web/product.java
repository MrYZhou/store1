package com.lar.store.web;

import com.lar.store.pojo.Category;
import com.lar.store.pojo.Product;
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
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class product {
    @Autowired
    ProductService productService;
    //商品添加
    @PostMapping("/products")
    public Object add(Product bean, MultipartFile image, HttpServletRequest request) throws Exception {
        System.out.println(bean);
        Date now=new Date();
        SimpleDateFormat sfd= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        now=sfd.parse(sfd.format(now));
        bean.setCreateDate(now);
        productService.add(bean);
        saveOrUpdateImageFile(bean, image, request);
        return bean;
    }
    public void saveOrUpdateImageFile(Product bean, MultipartFile image, HttpServletRequest request)
            throws IOException {
        String uri= ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static/img/product";
        //  System.out.println("图片保存路径"+uri);
        File imageFolder= new File(uri);
        File file = new File(imageFolder,bean.getId()+".jpg");
        if(!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        image.transferTo(file);
        BufferedImage img = ImageUtil.change2jpg(file);
        ImageIO.write(img, "jpg", file);
    }

    //获取商品页面内容
    @GetMapping("/categories/{cid}/products")
    public Page4Navigator<Product> list(@PathVariable("cid") int cid, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start<0?0:start;
        Page4Navigator<Product> page =productService.list(cid, start, size,5 );
        return page;
    }

    //删除一个对象
    @DeleteMapping("/products/{id}")
    public String delete(@PathVariable("id") int id)  throws Exception {
        productService.deleteBean(id);
        return null;
    }

    //商品获取
    @GetMapping("/products/{id}")
    public Product get(@PathVariable("id") int id) throws Exception {
        Product bean=productService.get(id);
        System.out.println("kkkkkkkk"+bean);
        return bean;
    }
}
