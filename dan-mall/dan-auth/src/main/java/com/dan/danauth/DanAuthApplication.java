package com.dan.danauth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = {"com.dan.dancommon", "com.dan.danauth"})
@EnableEurekaClient
@EnableDiscoveryClient
@MapperScan("com.dan.danauth.mapper")
@RestController
public class DanAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(DanAuthApplication.class, args);
	}

}
