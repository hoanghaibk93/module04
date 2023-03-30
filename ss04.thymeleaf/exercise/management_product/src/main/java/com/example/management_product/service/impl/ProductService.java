package com.example.management_product.service.impl;

import com.example.management_product.model.Product;
import com.example.management_product.repository.IProductRepository;
import com.example.management_product.repository.impl.ProductRepository;
import com.example.management_product.service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    private IProductRepository repository = new ProductRepository();

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Product product) {
        repository.save(product);
    }

    @Override
    public Product findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public void update(int id, Product productUpdate) {
        repository.update(id, productUpdate);
    }

    @Override
    public List<Product> searchByName(String name) {
        return repository.searchByName(name);
    }
}
