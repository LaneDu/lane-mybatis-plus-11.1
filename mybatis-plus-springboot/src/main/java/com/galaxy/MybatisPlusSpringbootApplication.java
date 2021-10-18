package com.galaxy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.galaxy.mapper")
public class MybatisPlusSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisPlusSpringbootApplication.class, args);
	}

}
