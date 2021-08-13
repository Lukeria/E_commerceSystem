package com.e_commerceSystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderController {

    @GetMapping("/orders")
    public ModelAndView orders(){
        return new ModelAndView("orders");
    }
}
