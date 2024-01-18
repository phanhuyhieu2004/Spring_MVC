package com.example.springblog.service;


import com.example.springblog.model.Bloger;

import java.util.List;

public interface BlogerService {
    List<Bloger> findAll();

    Bloger findById(long id);

    void save(Bloger bloger);

    void remove(long id);
}
