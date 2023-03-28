package com.example.calculator.service.impl;

import com.example.calculator.service.ICalculatorService;

public class CalculatorService implements ICalculatorService {
    @Override
    public double calculator(double numberOne, double numberTwo, String calculation) {
        double result = 0;
        switch (calculation) {
            case "Addition(+)":
                result = numberOne + numberTwo;
                break;
            case "Subtraction(-)":
                result = numberOne - numberTwo;
                break;
            case "Multiplication(x)":
                result = numberOne * numberTwo;
                break;
            case "Division(/)":
               result = numberOne / numberTwo;
                break;
            default:
                break;
        }
        return result;
    }
}
