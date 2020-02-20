package top.mengtech.springboot_mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.mengtech.springboot_mybatis.model.Country;
import top.mengtech.springboot_mybatis.service.CountryService;

import java.util.List;

/**
 * @ClassName TestController
 * @Description
 * @Author MQM
 * @Date 2020-02-19 10:21
 */

@RequestMapping("/test")
@Controller
public class TestController {
    @Autowired
    private CountryService countryService;

    @RequestMapping("/log")
    @ResponseBody
    public String log(){
        List<Country> countryList = countryService.selectAllCountryFirst();
        return countryList.toString();
    }

    @RequestMapping("/log2")
    @ResponseBody
    public String log2(){
        List<Country> countryList = countryService.selectAllCountrySecond();
        return countryList.toString();
    }
}
