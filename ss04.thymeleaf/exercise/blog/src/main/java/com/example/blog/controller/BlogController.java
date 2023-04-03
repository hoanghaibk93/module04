package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    IBlogService service;

    @GetMapping
    public String showList(Model model) {
        model.addAttribute("blogList", service.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/create")
    public String create(Blog blog, RedirectAttributes redirect) {
        service.save(blog);
        redirect.addFlashAttribute("message", "Create successful");
        return "redirect:/blog";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam(name = "delete") int id, RedirectAttributes redirect) {
        service.delete(id);
        redirect.addFlashAttribute("message", "Delete successful");
        return "redirect:/blog";
    }

    @GetMapping("/detail/{idBlog}")
    public String detail(@PathVariable Integer idBlog, Model model) {
        model.addAttribute("blog", service.findById(idBlog));
        return "detail";
    }

    @GetMapping("/edit/{idBlog}")
    public String showUpdateForm(@PathVariable Integer idBlog, Model model) {
        Optional<Blog> blog = Optional.ofNullable(service.findById(idBlog));
        if (blog.isPresent()) {
            model.addAttribute("blog", blog);
            return "edit";
        } else {
            return "error-404";
        }
    }

    @PostMapping("/edit")
    public String update(Blog blog, RedirectAttributes redirect) {
        service.save(blog);
        redirect.addFlashAttribute("message", "Update Successful");
        return "redirect:/blog";
    }

    @GetMapping("/search")
    public String search(@RequestParam(value = "name") String name, Model model) {
        model.addAttribute("blogList", service.findByName(name));
        return "list";
    }
}
