package com.example.springblog.service;


import com.example.springblog.model.Bloger;
import com.example.springblog.repository.BlogerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogerServiceIplm implements BlogerService {

    @Autowired
    private BlogerRepository blogerRepository;

    @Override
    public List<Bloger> findAll() {
        return blogerRepository.findAll();
    }

    @Override
    public Bloger findById(long id) {
        return blogerRepository.findById(id);
    }

    @Override
    public void save(Bloger bloger) {
        blogerRepository.save(bloger);
    }

    @Override
    public void remove(long id) {
        blogerRepository.remove(id);
    }
}
