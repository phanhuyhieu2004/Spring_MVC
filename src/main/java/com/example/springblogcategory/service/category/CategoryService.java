package com.example.springblogcategory.service.category;


import com.example.springblogcategory.model.Category;

import java.util.Optional;

public interface CategoryService {

    Iterable<Category> findAll();

    Optional<Category> findById(Long id);

    void save(Category category);

    void remove(Long id);
}
