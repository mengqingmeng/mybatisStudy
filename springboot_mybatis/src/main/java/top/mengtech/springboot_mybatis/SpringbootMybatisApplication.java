package top.mengtech.springboot_mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import top.mengtech.springboot_mybatis.mapper.CountryMapper;
import top.mengtech.springboot_mybatis.model.Country;

import java.util.List;

@SpringBootApplication
//@MapperScan({"top.mengtech.springboot_mybatis.mapper"})
public class SpringbootMybatisApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisApplication.class, args);
    }

    @Autowired
    private CountryMapper countryMapper;

    @Override
    public void run(String... args) throws Exception {
        List<Country> countryList = countryMapper.selectAll();
    }
}
