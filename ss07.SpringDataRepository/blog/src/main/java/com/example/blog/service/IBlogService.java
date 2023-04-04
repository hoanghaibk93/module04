package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAll(PageRequest pageRequest);

    void save(Blog blog);

    Blog findById(Integer id);

    void delete(Integer id);

    Page<Blog> findByName(String name, PageRequest pageRequest);

    Page<Blog> findByType(Integer id, PageRequest pageRequest);
}
