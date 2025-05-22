package com.affordmedical.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.affordmedical.backend.service.CalService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class CalculatorController {
    
    @Autowired
    private CalService calService;

    @GetMapping("/primes")
    public String primes(){
        
        return Double.toString(calService.primes());
    }
    
    @GetMapping("/fibo")
    public String fibo(){
        
        return Double.toString(calService.fib());
    }

    @GetMapping("/even")
    public String even(){
        
        return Double.toString(calService.even());
    }

    @GetMapping("/rand")
    public String rand(){
        
        return Double.toString(calService.rand());
    }
}
