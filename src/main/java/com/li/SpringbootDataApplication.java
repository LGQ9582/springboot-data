package com.li;

import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


//@EnableScheduling //开启定时任务的注解
@SpringBootApplication
public class SpringbootDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDataApplication.class, args);
	}

}
