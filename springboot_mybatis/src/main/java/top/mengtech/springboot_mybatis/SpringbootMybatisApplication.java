package top.mengtech.springboot_mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import top.mengtech.springboot_mybatis.mapper.CountryMapper;
import top.mengtech.springboot_mybatis.model.Country;

import java.util.List;

// 去掉spring boot自动装配的数据源
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
//@MapperScan({"top.mengtech.springboot_mybatis.mapper"})
public class SpringbootMybatisApplication{

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisApplication.class, args);
    }
}
