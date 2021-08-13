package com.e_commerceSystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {

    @GetMapping("/calculator")
    public ModelAndView calculator(){
        return new ModelAndView("calculator");
    }

    @PostMapping("/calculate")
    public ModelAndView calculate(){
        return new ModelAndView("calculator");
    }


}
