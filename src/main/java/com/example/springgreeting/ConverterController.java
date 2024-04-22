package com.example.springgreeting;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConverterController {
//    @GetMapping("/load")
//    public String converter() {
//        return "converter";
//    }
//
//    @PostMapping("/load")
//    public String submit(@RequestParam("usd") String usd, @RequestParam("rate") String rate, Model model) {
//        float result = Float.parseFloat(usd) * Float.parseFloat(rate);
//        model.addAttribute("result", result);
//        return "converter";
//    }

    @GetMapping("/converter")
   public ModelAndView getConverter(){
        ModelAndView modelAndView=new ModelAndView("converter");
        return modelAndView;
    }
//    @PostMapping("/converter")
//    public String submit(@RequestParam("rate") String rate,@RequestParam("usd") String usd,Model model){
//float result =Float.parseFloat(rate) * Float.parseFloat(usd);
//        model.addAttribute("result",result);
//        return "converter";
//
//    }














    @PostMapping("converter")
    public ModelAndView submit(@RequestParam("rate")String rate,@RequestParam("usd")String usd){
        float result=Float.parseFloat(rate)* Float.parseFloat(usd);
        ModelAndView modelAndView=new ModelAndView("converter");


        modelAndView.addObject("result",result);
        return modelAndView;
    }
}