package top.mengtech.springboot_mybatis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.mengtech.springboot_mybatis.interfaces.CurDataSource;
import top.mengtech.springboot_mybatis.mapper.CountryMapper;
import top.mengtech.springboot_mybatis.model.Country;
import top.mengtech.springboot_mybatis.service.CountryService;

import java.util.List;

/**
 * @ClassName CountryServiceImpl
 * @Description
 * @Author MQM
 * @Date 2020-02-19 15:43
 */

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryMapper countryMapper;

    @Override
    public List<Country> selectAllCountryFirst() {
        return countryMapper.selectAll();
    }

    @Override
    @CurDataSource(name="second")
    public List<Country> selectAllCountrySecond() {
        return countryMapper.selectAll();
    }
}
