package com.example.springgreeting;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetingController {
//@GetMapping("/helloSpringMVC")
//   public String home(){
//   return "/hello";
//}
//   @GetMapping("/helloSpringMVC")
//   public ModelAndView home(){
//      return new ModelAndView("/hello");
//   }"
   @RequestMapping("/helloName")
   public String home(@RequestParam String name,Model model){
 model.addAttribute("name",name);
      return "/hello";

   }
}
