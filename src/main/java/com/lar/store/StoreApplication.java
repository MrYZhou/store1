package com.lar.store;

import com.lar.store.util.PortUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableCaching
@EnableElasticsearchRepositories(basePackages = "com.lar.store.es")

@EnableJpaRepositories(basePackages = {"com.lar.store.mapper", "com.lar.store.pojo"})
public class StoreApplication {
	static {
		PortUtil.checkPort(9200,"Elastic 服务端",true);
//		PortUtil.checkPort(6379,"Redis 服务端",true);
	}
	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);
	}

}
