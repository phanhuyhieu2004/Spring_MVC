package com.example.springblogcategory.service.blog;

import com.example.springblogcategory.model.Blog;
import com.example.springblogcategory.model.Category;
import com.example.springblogcategory.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Iterable<Blog> findAllByCategory(Optional<Category> category) {
        return blogRepository.findAllByCategory(category);
    }

    @Override
    public Page<Blog> findAllByContentContaining(String content, Pageable pageable) {
        return blogRepository.findAllByContentContaining(content, pageable);
    }
}