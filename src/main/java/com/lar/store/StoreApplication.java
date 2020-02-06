package com.lar.store;

import com.lar.store.util.PortUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class StoreApplication {
	static {
		PortUtil.checkPort(6379,"Redis 服务端",true);
	}
	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);
	}

}
