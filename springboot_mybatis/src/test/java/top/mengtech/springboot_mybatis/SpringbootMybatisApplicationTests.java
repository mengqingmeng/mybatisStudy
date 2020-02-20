package top.mengtech.springboot_mybatis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.mengtech.springboot_mybatis.mapper.first.CountryMapper;
import top.mengtech.springboot_mybatis.service.CountryService;

@SpringBootTest
class SpringbootMybatisApplicationTests {
    @Autowired
    private CountryMapper countryMapper;
    @Autowired
    private CountryService countryService;

    @Test
    void contextLoads() {
        countryMapper.selectAll();
    }

    @Test
    void testMultiDataSource(){
        countryService.selectAllCountryFirst();
//        countryService.selectAllCountrySecond();
    }

}
