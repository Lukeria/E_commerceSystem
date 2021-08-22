package com.e_commerceSystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/order")
public class OrderController {

    @GetMapping("/")
    public ModelAndView order(){
        return new ModelAndView("order");
    }

    @GetMapping("/all")
    public ModelAndView orders(){
        return new ModelAndView("orders");
    }

    @PostMapping("/add")
    public ModelAndView addOrder(){
        return new ModelAndView();
    }

    @PostMapping("/alter")
    public ModelAndView alterOrder(){
        return new ModelAndView();
    }

    @PostMapping("/delete")
    public ModelAndView deleteOrder(){
        return new ModelAndView();
    }

    @PostMapping("/save")
    public ModelAndView saveOrder(){
        return new ModelAndView();
    }
}
