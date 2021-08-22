package com.e_commerceSystem.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cart")
public class CartController {

    @GetMapping("/")
    public ModelAndView cart(){
        return new ModelAndView("cart");
    }

    @PostMapping("/add")
    public ModelAndView cartAdd(){
        return new ModelAndView("calculator");
    }

    @PostMapping("/deleteItem")
    public ModelAndView cartDeleteItem(){
        return new ModelAndView("cart");
    }

    @PostMapping("/submit")
    public ModelAndView cartSubmit(){
        return new ModelAndView("cart");
    }
}
