package com.example.springpicture.controller;


import com.example.springpicture.model.Picture;
import com.example.springpicture.service.IPictureService;
import com.example.springpicture.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/pictureapp")
public class PictureController {
    private final IPictureService pictureService = new PictureService();
//
//    @Value("${file-upload}")
//    private String fileUpload;
    @GetMapping("")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("/home");
        modelAndView.addObject("listPicture", pictureService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("picture",new Picture());
        return modelAndView;
    }
    @PostMapping("/save")
    public ModelAndView save(Picture picture) throws IOException {
        ModelAndView modelAndView = new ModelAndView("redirect:/pictureapp");

       pictureService.save(picture);
        return modelAndView;
    }
}
