package com.example.youtube2.controller.api;

import com.example.youtube2.model.Video;
import com.example.youtube2.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("apiVideoController")
@RequestMapping("/api/v1")
public class VideoController {
    @Autowired
    private VideoService videoService;
    @GetMapping
    public ResponseEntity<Iterable<Video>> findAll(@RequestParam(required = false) String name) {
        List<Video> videos;
        if (name != null && !name.isEmpty()) {
            videos = (List<Video>) videoService.findAllByNameContaining(name);
        } else {
            videos = (List<Video>) videoService.findAll();
        }
        if (videos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(videos, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Video> findById(@PathVariable Long id) {
        Optional<Video> videoOptional = videoService.findById(id);
        if (!videoOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(videoOptional.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Video> saveVideo(@RequestBody Video video) {
        return new ResponseEntity<>(videoService.save(video), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Video> updateVideo(@PathVariable Long id, @RequestBody Video video) {
        Optional<Video> videoOptional = videoService.findById(id);
        if (!videoOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        video.setId(videoOptional.get().getId());
        return new ResponseEntity<>(videoService.save(video), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Video> deleteVideo(@PathVariable Long id) {
        Optional<Video> videoOptional = videoService.findById(id);
        if (!videoOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        videoService.remove(id);
        return new ResponseEntity<>(videoOptional.get(), HttpStatus.OK);
    }

}
