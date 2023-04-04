package com.example.blog.repository;

import com.example.blog.model.TypeOfBlog;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITypeOfBlogRepository extends PagingAndSortingRepository<TypeOfBlog, Integer> {
}
