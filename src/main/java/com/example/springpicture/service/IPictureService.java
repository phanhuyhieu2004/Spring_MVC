package com.example.springpicture.service;

import com.example.springpicture.model.Picture;

import java.util.List;
import java.util.Optional;

public interface IPictureService {
    List<Picture> findAll();


    void save(Picture picture);
}
