package com.example.springcountview.controller;

import com.example.springcountview.model.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
//@SessionAttributes("counter")
public class CounterController {


//    @ModelAttribute("counter")
//    public Counter setUpCounter() {
//        return new Counter();
//
//    }

//    @GetMapping("/counterViews")
//    public String getCounter(@ModelAttribute("counter") Counter counter) {
//
//
//        counter.increment();
//
//        return "/counterView";
//    }
    @GetMapping("/counterViews")
    public String getCounter(HttpSession httpSession,Counter counter,Model model) {


        httpSession.setAttribute("views",counter);
        counter.increment();

        Counter counter1= (Counter) httpSession.getAttribute("views");

model.addAttribute("counters",counter1);

        return "/counterView";
    }
}
