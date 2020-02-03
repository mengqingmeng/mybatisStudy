package top.mengtech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import top.mengtech.service.DictService;

import java.util.Date;

@Controller
public class IndexController {
    @Autowired
    private DictService dictService;

    @RequestMapping("index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("now",dictService.findById(1L));
        return  modelAndView;
    }
}
