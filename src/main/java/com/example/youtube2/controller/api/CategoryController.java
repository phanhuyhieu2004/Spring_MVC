package com.example.youtube2.controller.api;

import com.example.youtube2.model.Category;
import com.example.youtube2.model.Video;
import com.example.youtube2.service.CategoryService;
import com.example.youtube2.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("apiCategoryController")
@RequestMapping("/api/v2")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public ResponseEntity<Iterable<Category>> findAll() {
        List<Category> categorys = (List<Category>) categoryService.findAll();
        if (categorys.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categorys, HttpStatus.OK);
    }}