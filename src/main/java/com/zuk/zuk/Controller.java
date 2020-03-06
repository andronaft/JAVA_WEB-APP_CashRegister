package com.zuk.zuk;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zuk.zuk.service.impl.GoodServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Controller {

    private final GoodServiceImpl goodService;

    @Autowired
    public Controller(@Qualifier("GoodServiceImpl") GoodServiceImpl goodService){this.goodService = goodService;}

    @Autowired
    JsonMaker jsonMaker;

    @RequestMapping("/")
    @ResponseBody
    ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.html");
        return modelAndView;
    }

    @RequestMapping("/hello")
    @ResponseBody
    String hello() {


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.html");
        return jsonMaker.listToJson(goodService.findAll());
    }
}
