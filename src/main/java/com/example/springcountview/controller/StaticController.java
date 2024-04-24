package com.example.springcountview.controller;

import com.example.springcountview.model.Counter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class StaticController {
    @GetMapping("/static-count")
    public ModelAndView viewCount(Counter counter){

        ModelAndView modelAndView=new ModelAndView("/counterView");
        counter.increment();
        System.out.println(counter.getCount());

        return modelAndView;
    }
}
