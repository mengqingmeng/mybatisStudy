package top.mengtech.springboot_mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

// 去掉spring boot自动装配的数据源
@SpringBootApplication
public class SpringbootMybatisApplication{

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisApplication.class, args);
    }
}
