package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ITypeOfBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    IBlogService blogService;
    @Autowired
    ITypeOfBlogService typeOfBlogService;

    @GetMapping
    public String showList(Model model, @RequestParam(defaultValue = "0") int page) {
        Sort sort = Sort.by("dateCreateBlog").descending();
        model.addAttribute("blogList", blogService.findAll(PageRequest.of(page, 2, sort)));
        model.addAttribute("listType", typeOfBlogService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("listType", typeOfBlogService.findAll());
        return "create";
    }

    @PostMapping("/create")
    public String create(Blog blog, RedirectAttributes redirect) {
        blogService.save(blog);
        redirect.addFlashAttribute("message", "Create successful");
        return "redirect:/blog";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam(name = "delete") int id, RedirectAttributes redirect) {
        blogService.delete(id);
        redirect.addFlashAttribute("message", "Delete successful");
        return "redirect:/blog";
    }

    @GetMapping("/detail/{idBlog}")
    public String detail(@PathVariable Integer idBlog, Model model) {
        model.addAttribute("blog", blogService.findById(idBlog));
        return "detail";
    }

    @GetMapping("/edit/{idBlog}")
    public String showUpdateForm(@PathVariable Integer idBlog, Model model) {
        Optional<Blog> blog = Optional.ofNullable(blogService.findById(idBlog));
        if (blog.isPresent()) {
            model.addAttribute("blog", blog);
            model.addAttribute("listType", typeOfBlogService.findAll());
            return "edit";
        } else {
            return "error-404";
        }
    }

    @PostMapping("/edit")
    public String update(Blog blog, RedirectAttributes redirect) {
        blogService.save(blog);
        redirect.addFlashAttribute("message", "Update Successful");
        return "redirect:/blog";
    }

    @GetMapping("/search")
    public String search(@RequestParam(value = "name") String name, Model model, @RequestParam(defaultValue = "0") int page) {
        model.addAttribute("blogList", blogService.findByName(name, PageRequest.of(page, 2)));
        return "list";
    }

    @GetMapping("/listType/{id}")
    public String searchByTypeOfBlog(@PathVariable Integer id, Model model, @RequestParam(defaultValue = "0") int page) {
        model.addAttribute("blogList", blogService.findByType(id, PageRequest.of(page, 2)));
        model.addAttribute("listType", typeOfBlogService.findAll());
        return "list";
    }
}
