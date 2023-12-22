package com.example.springgreeting;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConverterController {
    @GetMapping("/load")
    public String converter() {
        return "converter";
    }

    @PostMapping("/load")
    public String submit(@RequestParam("usd") String usd, @RequestParam("rate") String rate, Model model) {
        float result = Float.parseFloat(usd) * Float.parseFloat(rate);
        model.addAttribute("result", result);
        return "converter";
    }
}