package com.example.tester.repository;

import com.example.tester.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE p.price BETWEEN :minPrice AND :maxPrice")
    List<Product> findByPrice(Double minPrice, Double maxPrice);
     @Query(value = "SELECT * FROM Product p ORDER BY p.price DESC LIMIT 3 ", nativeQuery = true)
    List<Products> findTop3();
    @Query(value = "SELECT * FROM Product p ORDER BY p.amount ASC", nativeQuery = true)
    List<Products> sortProducts();
}
