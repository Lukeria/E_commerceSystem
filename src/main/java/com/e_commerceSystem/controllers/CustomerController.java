package com.e_commerceSystem.controllers;

import com.e_commerceSystem.entities.Customer;
import com.e_commerceSystem.entities.Order;
import com.e_commerceSystem.services.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/add")
    public ModelAndView addCustomer(@ModelAttribute("customer") Customer customer,
                                    @ModelAttribute("orderId") Long orderId,
                                    HttpServletRequest request, RedirectAttributes redirectAttributes){

        ModelAndView modelAndView = new ModelAndView("/admin/customers/add");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("orderId", orderId);
        return  modelAndView;

    }

//    @PostMapping("/add")
//    public ModelAndView addCustomerPost(@ModelAttribute("customer") Customer customer,
//                                        HttpServletRequest request){
//
//        return addCustomer(customer, request);
//    }

    @PostMapping("/saveOrderCustomer")
    public ModelAndView saveOrderCustomer(@ModelAttribute("customer") Customer customer,
                                          @RequestParam("orderId") Long orderId,
                                          RedirectAttributes redirectAttributes) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/order/" + orderId);

        Order order = orderService.getOrderById(orderId);
        order.setCustomer(customer);
        orderService.updateOrderCustomer(order);

        return modelAndView;
    }

}
