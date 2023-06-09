package com.example.blog.service;


import com.example.blog.model.Blog;
import org.springframework.data.domain.PageRequest;

import java.util.List;


public interface IBlogService {

    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(Integer id);

    void delete(Integer id);

    List<Blog> findByName(String name);

    List<Blog> findByType(Integer id);
}
