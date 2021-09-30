package com.e_commerceSystem.controllers;

import com.e_commerceSystem.additional.ComponentViews;
import com.e_commerceSystem.services.interfaces.OrderService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Map;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    public ModelAndView cart(Principal principal){

        ModelAndView modelAndView = new ModelAndView("/user/cart");
        modelAndView.addObject("cartOrders", orderService.getOrdersByStatus("Cart"));

        return modelAndView;
    }

    @PostMapping("/add")
    @ResponseBody
    @JsonView(ComponentViews.Normal.class)
    public ModelAndView cartAdd(@RequestParam Map<String,String> allParams){
        return new ModelAndView("redirect:/cart/");
    }

    @PostMapping("/deleteItem")
    public ModelAndView cartDeleteItem(){
        return new ModelAndView("/user/cart");
    }

    @PostMapping("/submit")
    public ModelAndView cartSubmit(){
        return new ModelAndView("/user/cart");
    }
}
