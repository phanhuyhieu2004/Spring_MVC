package com.example.jwtspring3.service;



import com.example.jwtspring3.model.Product;

import java.util.List;

public interface IProductService extends IGeneralService<Product>{

    List<Product> findByPrice(Double minPrice, Double maxPrice);

}
