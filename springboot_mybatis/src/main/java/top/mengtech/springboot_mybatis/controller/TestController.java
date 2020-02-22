package top.mengtech.springboot_mybatis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName TestController
 * @Description
 * @Author MQM
 * @Date 2020-02-19 10:21
 */

@RequestMapping("/test")
@Controller
public class TestController {

    @RequestMapping("/log")
    @ResponseBody
    public String log(){
        return "test log ok";
    }
}
