package com.example.customermanagementthymeleaf.service;

import com.example.customermanagementthymeleaf.model.Customer;
import com.example.customermanagementthymeleaf.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update(int id, Product product);

    void remove(int id);

    List<Product> searchByName(String name);
}
