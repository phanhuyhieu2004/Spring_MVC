package com.example.springmusic.service;

import com.example.springmusic.model.Song;

import java.util.List;
import java.util.Optional;

public interface ISongService {
    List<Song> findAll();
    Song findById(int id);

    void save(Song song);
}
