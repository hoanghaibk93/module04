package com.example.blog.repository;

import com.example.blog.model.TypeOfBlog;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ITypeOfBlogRepository extends PagingAndSortingRepository<TypeOfBlog, Integer> {
}
