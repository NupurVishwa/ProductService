package com.example.capstoneproject.Calculator;

import org.springframework.stereotype.Service;

@Service

public class calculatorService {
    public int addInService(int a, int b)
    {
        System.out.println("Service: Some logic here");
        System.out.println("Service: Some logic before add");
        int result = a + b;
        System.out.println("Service: Some logic after add");

        return result;
    }
}
