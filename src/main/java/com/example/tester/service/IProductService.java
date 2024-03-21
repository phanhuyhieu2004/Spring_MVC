package com.example.tester.service;




import com.example.tester.model.Product;

import java.util.List;

public interface IProductService extends IGeneralService<Product>{

    List<Product> findByPrice(Double minPrice, Double maxPrice);

}
