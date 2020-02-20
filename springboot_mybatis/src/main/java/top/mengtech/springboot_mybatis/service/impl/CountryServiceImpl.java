package top.mengtech.springboot_mybatis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import top.mengtech.springboot_mybatis.mapper.first.CountryMapper;
import top.mengtech.springboot_mybatis.mapper.second.CountryMapper2;
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
    private CountryMapper firstCountryMapper;
    @Autowired
    private CountryMapper2 secondCountryMapper;

    @Override
    public List<Country> selectAllCountryFirst() {
        return firstCountryMapper.selectAll();
    }

    @Override
    public List<Country> selectAllCountrySecond() {
        return secondCountryMapper.selectAll();
    }
}
