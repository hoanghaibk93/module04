package com.example.calculator.controller;

import com.example.calculator.service.ICalculatorService;
import com.example.calculator.service.calculaterImpl.CalculatorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    private ICalculatorService service = new CalculatorService();

    @GetMapping("/calculate")
    public String calculate() {
        return "calculator";
    }

    @PostMapping("/calculate/result")
    public String calculate(@RequestParam(name = "calculation") String calculation, @RequestParam(name = "numberOne") double numberOne, @RequestParam(name = "numberTwo") double numberTwo, Model model) {
        double result = service.calculator(numberOne, numberTwo, calculation);
        if (calculation.equals("Division(/)") && numberTwo == 0) {
            String resultOther = "Error: Division by zero";
            model.addAttribute("numberOne", numberOne);
            model.addAttribute("numberTwo", numberTwo);
            model.addAttribute("result", resultOther);
            return "calculator";
        } else {
            model.addAttribute("numberOne", numberOne);
            model.addAttribute("numberTwo", numberTwo);
            model.addAttribute("result", result);
            return "calculator";
        }
    }
}
