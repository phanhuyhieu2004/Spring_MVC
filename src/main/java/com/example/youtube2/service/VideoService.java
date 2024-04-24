package com.example.youtube2.service;

import com.example.youtube2.model.Video;
import com.example.youtube2.repository.IVideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VideoService implements IVideoService {
    @Autowired
    private IVideoRepository iVideoRepository;


    @Override
    public Iterable<Video> findAll() {
        return iVideoRepository.findAll();
    }

    @Override
    public Video save(Video video) {
        return iVideoRepository.save(video);
    }

    @Override
    public void remove(Long id) {
        iVideoRepository.deleteById(id);
    }

    @Override
    public Optional<Video> findById(Long id) {
        return iVideoRepository.findById(id);
    }
    public Iterable<Video> findAllByNameContaining(String name){
        return iVideoRepository.findAllByNameContaining(name);
    }
}
