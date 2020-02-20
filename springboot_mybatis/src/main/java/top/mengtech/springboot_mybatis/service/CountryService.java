package top.mengtech.springboot_mybatis.service;

import top.mengtech.springboot_mybatis.model.Country;

import java.util.List;

public interface CountryService {
    List<Country> selectAllCountryFirst();
    List<Country> selectAllCountrySecond();
}
