package com.e_commerceSystem.controllers;

import com.e_commerceSystem.entities.Customer;
import com.e_commerceSystem.entities.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @GetMapping("/add")
    public ModelAndView addCustomer(@ModelAttribute("customer") Customer customer,
                                    HttpServletRequest request){

        ModelAndView modelAndView = new ModelAndView("/admin/customers/add");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("orderId", request.getAttribute("orderId"));
        return  modelAndView;

    }

    @PostMapping("/add")
    public ModelAndView addCustomerPost(@ModelAttribute("customer") Customer customer,
                                        HttpServletRequest request){

        return addCustomer(customer, request);
    }

}
