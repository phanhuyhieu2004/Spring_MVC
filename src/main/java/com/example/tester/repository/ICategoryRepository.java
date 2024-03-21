package com.example.jwtspring3.repository;

import com.example.jwtspring3.model.Category;
import com.example.jwtspring3.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
