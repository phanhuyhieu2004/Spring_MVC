package com.example.springmusic.controller;

import com.example.springmusic.model.Song;
import com.example.springmusic.service.ISongService;
import com.example.springmusic.service.SongService;
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
@RequestMapping("/musicapp")
public class MusicController {
    private final ISongService songService = new SongService();

    @Value("${file-upload}")
    private String fileUpload;
    @GetMapping("")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("/home");
        modelAndView.addObject("listSong", songService.findAll());
        return modelAndView;
    }
    @GetMapping("/{id}/view")
    public ModelAndView showView(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/view");
        modelAndView.addObject("song", songService.findById(id));
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("song",new Song());
        return modelAndView;
    }
    @PostMapping("/save")
    public ModelAndView save(@RequestParam("filePath") MultipartFile filePath, Song song) throws IOException {
        ModelAndView modelAndView = new ModelAndView("redirect:/musicapp");
        String fileName = filePath.getOriginalFilename();
        FileCopyUtils.copy(filePath.getBytes(), new File(fileUpload + fileName));
        songService.save(new Song(song.getNameSong(), song.getNameSinger(), song.getKindOfMusic(), fileName));
        return modelAndView;
    }
}
