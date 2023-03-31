package com.example.management_product.repository.impl;

import com.example.management_product.model.Product;
import com.example.management_product.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

import static com.example.management_product.repository.impl.BaseRepository.entityManager;

@Repository
public class ProductRepository implements IProductRepository {

    static List<Product> productList = new ArrayList<>();


    @Override
    public List<Product> findAll() {
        List<Product> productList = entityManager
                .createQuery("select s from Product s", Product.class).getResultList();
        return productList;
    }

    @Override
    public void save(Product product) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(product);
        entityTransaction.commit();
    }

    @Override
    public Product findById(int id) {
        String queryStr = "Select s from Product as s where s.id = :id";
        Product product = entityManager.createQuery(queryStr, Product.class).setParameter("id", id).getSingleResult();
        return product;
    }

    @Override
    public void delete(int id) {
        Product product = findById(id);
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.remove(product);
        entityTransaction.commit();
    }

    @Override
    public void update(int id, Product productUpdate) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.merge(productUpdate);
        entityTransaction.commit();
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
