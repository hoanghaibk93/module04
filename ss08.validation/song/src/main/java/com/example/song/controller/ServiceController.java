package com.example.song.controller;

import com.example.song.model.Song;
import com.example.song.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/song")
public class ServiceController {
    @Autowired
    ISongService songService;

    @GetMapping
    public String showList(Model model) {
        model.addAttribute("listSong", songService.findAll());
        return "list";
    }
    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("song", new Song());
        return "create";
    }
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute Song song, RedirectAttributes redirect, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "create";
        } else {
           model.addAttribute("song", song);
           return "redirect:/song";
        }
    }
}
