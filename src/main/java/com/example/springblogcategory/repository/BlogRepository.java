package com.example.springblogcategory.repository;


import com.example.springblogcategory.model.Blog;
import com.example.springblogcategory.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface BlogRepository extends PagingAndSortingRepository<Blog, Long> {
    Iterable<Blog> findAllByCategory(Optional<Category> category);

    Page<Blog> findAllByContentContaining(String content, Pageable pageable);
}
