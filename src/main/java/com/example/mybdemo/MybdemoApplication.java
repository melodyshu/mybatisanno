package com.example.mybdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan("com.example.**.mapper")
public class MybdemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(MybdemoApplication.class, args);
  }

}
