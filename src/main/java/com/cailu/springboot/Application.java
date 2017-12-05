package com.cailu.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
@MapperScan("com.cailu.springboot.mapper")
public class Application {
	//定义一个全局的记录器，通过LoggerFactory获取
    private final static Logger logger = LoggerFactory.getLogger(Application.class); 
	/*@RequestMapping("/hello")
	public String hello(){
		return "hello";
	}*/
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		logger.info("成功启动在线接口文档项目");
	}
	
	 
}



