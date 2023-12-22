package com.example.springgreeting;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    @GetMapping("translate")
    public String viewDictionary(){
        return "dictionary";
    }
    @PostMapping("translate")
    public String dictionary(@RequestParam("key") String key, Model model) {
        Map<String, String> maps = new HashMap<>();
        maps.put("love", "yêu");
        maps.put("hate", "ghét");
        maps.put("cry", "khóc");
        maps.put("laugh", "cười");
        maps.put("book", "sách");

        if (maps.containsKey(key)) {
            model.addAttribute("result", maps.get(key));
        } else {
            model.addAttribute("message", "Not found");
        }
        return "dictionary";
    }
}
