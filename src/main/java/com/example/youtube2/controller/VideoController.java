package com.example.youtube2.controller;

import com.example.youtube2.model.Category;
import com.example.youtube2.model.Video;
import com.example.youtube2.service.CategoryService;
import com.example.youtube2.service.VideoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Iterator;
import java.util.Optional;

@Controller

public class VideoController {
    @Autowired
    private VideoService videoService;
    @Autowired
    private CategoryService categoryService;
    @ModelAttribute("categorys")
    public Iterable<Category> findAll() {
        return categoryService.findAll();
    }


    @GetMapping("/videos")
    public ModelAndView show(@RequestParam(name = "s", required = false) String searchTerm) {
        Iterable<Video> videos ;
        if (searchTerm != null && !searchTerm.isEmpty()) {
            videos = videoService.findAllByNameContaining(searchTerm);
        } else {
            videos = videoService.findAll();
        }
        return new ModelAndView("list", "videos", videos);
    }

    @GetMapping("/create-video")
    public ModelAndView createForm() {
        return new ModelAndView("create", "video", new Video());
    }

    @PostMapping("/create-video")
    public String save(@Valid @ModelAttribute("video") Video video, RedirectAttributes redirectAttributes, Model model) {

        videoService.save(video);
        model.addAttribute("video", new Video());
        redirectAttributes.addFlashAttribute("message", "tạo thành công ");
        return "redirect:/videos";
    }

    @GetMapping("/delete-video/{id}")
    public String deleteVideo(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        Optional<Video> video = videoService.findById(id);
        videoService.remove(video.get().getId());
        redirectAttributes.addFlashAttribute("message", "xóa thành công");
        return "redirect:/videos";
    }

    @GetMapping("/edit-video/{id}")
    public ModelAndView showEdit(@PathVariable Long id) {
        Optional<Video> video = videoService.findById(id);
        return new ModelAndView("edit", "video", video.get());

    }

    @PostMapping("/edit-video")
    public String editVideo(@Valid @ModelAttribute("video") Video video,RedirectAttributes redirectAttributes, Model model) {

        videoService.save(video);
        model.addAttribute("video", video);

        redirectAttributes.addFlashAttribute("message", "sửa thành công");
        return "redirect:/videos";
    }
}
