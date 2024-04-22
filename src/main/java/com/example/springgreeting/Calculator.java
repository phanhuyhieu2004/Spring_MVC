package com.example.springgreeting;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Calculator {
    @GetMapping("/calculate")
    public ModelAndView showCalculator() {
        return new ModelAndView("calculator");
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam(name = "number1") int number1,
                            @RequestParam(name = "number2") int number2,
                            @RequestParam(name = "calculation") String operation, Model model, RedirectAttributes redirectAttributes
                            ) {

        int result = 0;
        switch (operation) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "X":
                result = number1 * number2;
                break;
            case "/":
                result = number1 / number2;
                break;
        }

        model.addAttribute("number1",number1);
        model.addAttribute("number2",number2);
        redirectAttributes.addFlashAttribute("result",result);
        redirectAttributes.addFlashAttribute("sucess","thành công rồi hi hi");
        return "redirect:/result";
    }
    @GetMapping("/result")
    public String resultCalculator(){
        return "result";
    }
}