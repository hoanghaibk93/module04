package com.example.song.controller;

import com.example.song.dto.SongDTO;
import com.example.song.model.Song;
import com.example.song.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
    public String showFormCreate(Model model) {
        model.addAttribute("songDtoCreate", new SongDTO());
        return "create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("songDtoCreate") SongDTO songDTO, BindingResult bindingResult, RedirectAttributes redirect, Model model) {
        if (bindingResult.hasErrors()) {
            return "create";
        } else {
            Song song = new Song();
            BeanUtils.copyProperties(songDTO, song);
            songService.save(song);
            model.addAttribute("songDTO", songDTO);
            return "redirect:/song";
        }
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        model.addAttribute("songDtoCreate", songService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String showEditForm(@Valid @ModelAttribute("songDtoCreate") SongDTO songDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "edit";
        } else {
            Song song = new Song();
            BeanUtils.copyProperties(songDTO, song);
            songService.save(song);
            return "redirect:/song";
        }
    }
}
