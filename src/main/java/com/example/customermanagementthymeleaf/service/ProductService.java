package com.example.customermanagementthymeleaf.service;

import com.example.customermanagementthymeleaf.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService{
    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "John", 45, "Ha Noi"));
        products.put(2, new Product(2, "Bill",33, "Hai Phong"));
        products.put(3, new Product(3, "Alex", 24, "Sai Gon"));
        products.put(4, new Product(4, "Adam", 35, "Beijing"));
        products.put(5, new Product(5, "Sophia", 68, "Miami"));
        products.put(6, new Product(6, "Rose", 56, "NewYork"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save( Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);

    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
    @Override
    public List<Product> searchByName(String name) {
        List<Product> searchResults = new ArrayList<>();
        for (Product product : products.values()) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                searchResults.add(product);
            }
        }
        return searchResults;
    }
}

