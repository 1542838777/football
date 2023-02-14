package com.tongxue.footballguessing;

import com.dtflys.forest.springboot.annotation.ForestScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
@ForestScan(basePackages = "com.tongxue.footballguessing.HttpClient")
@MapperScan("com.tongxue.footballguessing.persistence")

public class FootballGuessingApplication {


	public static void main(String[] args) {

		SpringApplication.run(FootballGuessingApplication.class, args);
	}

}
