package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.model.TypeOfBlog;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ITypeOfBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/type")
public class TypeOfBlogController {
    @Autowired
    ITypeOfBlogService typeOfBlogService;
    @Autowired
    IBlogService blogService;

    @GetMapping("")
    public ResponseEntity<List<TypeOfBlog>> showList() {
        return new ResponseEntity<>(typeOfBlogService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{idTypeOfBlog}")
    public ResponseEntity<List<Blog>> searchByTypeOfBlog(@PathVariable Integer idTypeOfBlog) {
        return new ResponseEntity<>(blogService.findByType(idTypeOfBlog), HttpStatus.OK);
    }
}
