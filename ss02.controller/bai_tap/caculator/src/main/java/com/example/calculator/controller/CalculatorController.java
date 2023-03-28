package com.example.calculator.controller;

import com.example.calculator.service.ICalculatorService;
import com.example.calculator.service.impl.CalculatorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    private ICalculatorService service = new CalculatorService();

    @GetMapping
    public String calculate() {
        return "calculator";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam("calculation") String calculation, @RequestParam("numberOne") double numberOne, @RequestParam("numberTwo") double numberTwo, Model model) {
        double result = service.calculator(numberOne, numberTwo, calculation);
        if (calculation.equals("Division(/)") && numberTwo == 0) {
            String resultOther = "Error: Division by zero";
            model.addAttribute("result", resultOther);
        } else {
            model.addAttribute("result", result);
        }
        model.addAttribute("numberOne", numberOne);
        model.addAttribute("numberTwo", numberTwo);
        return "calculator";
    }
}
