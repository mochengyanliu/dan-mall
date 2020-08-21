package com.dan.danbusiness;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = {"com.dan.danbusiness", "com.dan.dancommon"})
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.dan.danbusiness.mapper")
@RestController
public class DanBusinessApplication {

	public static void main(String[] args) {
		SpringApplication.run(DanBusinessApplication.class, args);
	}

}
