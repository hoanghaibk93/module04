package com.example.management_product.repository.impl;

import com.example.management_product.model.Product;
import com.example.management_product.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "book1", 12000, "best seller", "Tuoi Tre"));
        productList.add(new Product(2, "book2", 15000, "best seller", "Ha Noi"));
        productList.add(new Product(3, "book3", 14000, "best seller", "Hoa Hoc Tro"));
        productList.add(new Product(5, "book5", 15000, "best seller", "Tuoi Tre"));
        productList.add(new Product(4, "book4", 16000, "best seller", "Tuoi Tre"));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public Product findById(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void delete(int id) {
        Product product = findById(id);
        productList.remove(product);
    }

    @Override
    public void update(int id, Product productUpdate) {
        Product product = findById(id);
        findAll().set(findAll().indexOf(product), productUpdate);
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> productList = new ArrayList<>();
        for (Product product : findAll()) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                productList.add(product);
            }
        }
        return productList;
    }
}
