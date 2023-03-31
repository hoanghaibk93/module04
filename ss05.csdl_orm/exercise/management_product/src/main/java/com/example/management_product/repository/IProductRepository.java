package com.example.management_product.repository;

import com.example.management_product.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    void save(Product product);

    Product findById(int id);

    void delete(int id);

    void update(int id, Product productUpdate);

    List<Product> searchByName(String name);
}
