package com.example.management_product.controller;

import com.example.management_product.model.Product;
import com.example.management_product.service.IProductService;
import com.example.management_product.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private IProductService service;

    @GetMapping("/product")
    public String showListProduct(Model model) {
        List<Product> productList = service.findAll();
        model.addAttribute("productList", productList);
        return "list";
    }

    @RequestMapping(value = "/product/create", method = RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @RequestMapping(value = "/product/create", method = RequestMethod.POST)
    public String create(Product product, RedirectAttributes redirect) {
        service.save(product);
        redirect.addFlashAttribute("message", "Create Successful");
        return "redirect:/product";
    }

    @GetMapping("/product/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirect) {
        service.delete(id);
        redirect.addFlashAttribute("message", "Delete Successful");
        return "redirect:/product";
    }

    @GetMapping("/product/detail/{id}")
    public String detail(@PathVariable int id, Model model) {
        model.addAttribute("product", service.findById(id));
        return "detail";
    }

    @GetMapping("/product/edit/{id}")
    public String showUpdateForm(@PathVariable int id, Model model) {
        model.addAttribute("product", service.findById(id));
        return "update";
    }

    @PostMapping("/product/edit")
    public String update(Product product, RedirectAttributes redirect) {
        service.update(product.getId(), product);
        redirect.addFlashAttribute("message", "Edit Successful");
        return "redirect:/product";
    }

    @GetMapping("/product/search")
    public String searchByName(@RequestParam String name, Model model) {
        model.addAttribute("productList", service.searchByName(name));
        if (service.searchByName(name).isEmpty()) {
            model.addAttribute("notice", "Not Found");
        }
        return "list";
    }
}
