package com.e_commerceSystem.controllers;

import com.e_commerceSystem.additional.ComponentViews;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/cart")
public class CartController {

    @GetMapping("/")
    public ModelAndView cart(){
        return new ModelAndView("/user/cart");
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
