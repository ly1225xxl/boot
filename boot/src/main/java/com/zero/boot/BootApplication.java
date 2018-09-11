package com.zero.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@MapperScan("com.zero.boot.mapper")
public class BootApplication extends WebMvcConfigurerAdapter{
	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class,args);
	}
}
