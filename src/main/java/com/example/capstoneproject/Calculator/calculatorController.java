package com.example.capstoneproject.Calculator;

import org.springframework.stereotype.Controller;

@Controller
public class calculatorController {
    public calculatorService calculatorService;

    public calculatorController(calculatorService calculatorService)
    {
        this.calculatorService = calculatorService;
    }


    public int add(int a, int b)
    {
        System.out.println("Controller: Some logic here");
        System.out.println("Controller: Some logic before add");
        int result = calculatorService.addInService(a,b);
        System.out.println("Controller: Some logic after add");

        return result;
    }
}
