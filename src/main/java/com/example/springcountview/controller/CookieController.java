package com.example.springcountview.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CookieController {
@GetMapping("/cookie-counter")
    public ModelAndView getCookieCounter(@CookieValue(value = "views",defaultValue = "0")long views, HttpServletResponse httpServletResponse){
    Cookie cookie=new Cookie("views",String.valueOf(views+1));
    cookie.setMaxAge(120);
    httpServletResponse.addCookie(cookie);



    ModelAndView modelAndView =new ModelAndView("/counterView");
    modelAndView.addObject("title","Cookie views");
    modelAndView.addObject("viewsCookie",cookie.getValue());
    return modelAndView;
}
}
