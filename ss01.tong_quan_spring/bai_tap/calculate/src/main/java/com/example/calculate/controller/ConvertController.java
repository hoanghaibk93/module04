package com.example.calculate.controller;

import com.example.calculate.service.ConvertService;
import com.example.calculate.service.IConvertService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {
    IConvertService service = new ConvertService();

    @GetMapping("/calculate")
    public String calculate() {
        return "calculate";
    }

    @PostMapping("/calculate/result")
    public String calculate(@RequestParam(name = "rate") float rate, @RequestParam(name = "usd") float usd, Model model) {
        float result = service.convert(rate, usd);
        model.addAttribute("rate", rate);
        model.addAttribute("usd", usd);
        model.addAttribute("result", result);
        return "calculate";
    }
}
