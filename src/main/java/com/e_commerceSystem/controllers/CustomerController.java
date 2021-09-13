package com.e_commerceSystem.controllers;

import com.e_commerceSystem.entities.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @GetMapping("/add")
    public ModelAndView addCustomer(){

        ModelAndView modelAndView = new ModelAndView("/admin/customers/add");
        return  modelAndView;

    }

}
