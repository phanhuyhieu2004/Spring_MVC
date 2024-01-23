package com.example.springblogcategory.service.blog;


import com.example.springblogcategory.model.Blog;
import com.example.springblogcategory.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface BlogService {

    Page<Blog> findAll(Pageable pageable);

    Optional<Blog> findById(Long id);

    void save(Blog blog);

    void remove(Long id);

    Iterable<Blog> findAllByCategory(Optional<Category> category);

    Page<Blog> findAllByContentContaining(String content, Pageable pageable);
}
