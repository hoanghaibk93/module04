package com.example.blog.service;

import com.example.blog.model.TypeOfBlog;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ITypeOfBlogService {
    List<TypeOfBlog> findAll();

}
