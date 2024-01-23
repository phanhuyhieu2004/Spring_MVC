package com.example.springblogcategory.controller;


import com.example.springblogcategory.model.Blog;
import com.example.springblogcategory.model.Category;
import com.example.springblogcategory.service.blog.BlogService;
import com.example.springblogcategory.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categorys")
    public Iterable<Category> categories() {
        return categoryService.findAll();
    }

    @GetMapping("/blogs")
    public ModelAndView showListBlog(@RequestParam("s") Optional<String> s, @PageableDefault(value = 1) Pageable pageable) {
        Page<Blog> blogs;
        if (s.isPresent()) {
            blogs = blogService.findAllByContentContaining(s.get(), pageable);
        } else {
            blogs = blogService.findAll(pageable);
        }

        ModelAndView modelAndView;
        if (blogs.isEmpty()) {
            modelAndView = new ModelAndView("/blog/notfound");
        } else {
            modelAndView = new ModelAndView("/blog/list");
            modelAndView.addObject("blogs", blogs);
        }
        return modelAndView;
    }

    @GetMapping("/create-blog")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/create-blog")
    public ModelAndView createBlog(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);

        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "Thành công");
        return modelAndView;
    }


    @GetMapping("/view-blog/{id}")
    public ModelAndView detailInformationBlog(@PathVariable Long id) {
        Optional<Blog> blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/blog/view");
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

    @GetMapping("/update-blog/{id}")
    public ModelAndView showUpdateForm(@PathVariable Long id) {
        Optional<Blog> blog = blogService.findById(id);

        if (blog==null) {
            return new ModelAndView("/error.404");
        }
        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        modelAndView.addObject("blog", blog.get());
        return modelAndView;
    }

    @PostMapping("/update-blog")
    public ModelAndView updateBlog(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);

        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "Blog updated compliment");
        return modelAndView;
    }


    @GetMapping("/delete-blog/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Blog> blog = blogService.findById(id);

        if (blog==null) {
            return new ModelAndView("/error.404");
        }

        ModelAndView modelAndView = new ModelAndView("/blog/delete");
        modelAndView.addObject("blog", blog.get());
        return modelAndView;
    }

    @PostMapping("/delete-blog")
    public String deleteBlog(@ModelAttribute("blog") Blog blog) {
        blogService.remove(blog.getId());

        return "redirect:blogs";
    }













}
