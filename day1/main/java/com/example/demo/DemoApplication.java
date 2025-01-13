package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan /* (basePackages = "com.example.demo") 안붙여도됨 */
//@ComponentScan(basePackages = "annotation.springmvc")
//@ComponentScan(basePackages = "myconfig")
//@MapperScan(basePackages = "annotation.springmvc.mybatis")
@ComponentScan(basePackages = "boardmapper")
@MapperScan(basePackages = "boardmapper")
@ComponentScan(basePackages = "react.ajax")
public class DemoApplication {

	public static void main(String[] args) {
		System.out.println("스프링부트서버 시작");
		SpringApplication.run(DemoApplication.class, args);
	}

}
