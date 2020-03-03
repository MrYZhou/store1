package com.lar.store.es;

import com.lar.store.pojo.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component
public interface ProductResposity extends ElasticsearchRepository<Product,String> {

    Page<Product> findAllByGoodsnameContaining(String name,Pageable pageable);
}
