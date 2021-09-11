package com.e_commerceSystem.controllers;

import com.e_commerceSystem.entities.Order;
import com.e_commerceSystem.entities.glass.Glass;
import com.e_commerceSystem.services.interfaces.OrderService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    public ModelAndView order() {
        return new ModelAndView("order");
    }

    @PostMapping("/create")
    public ModelAndView createOrder(@RequestParam Map<String, String> allParams) {

        ModelAndView modelAndView = new ModelAndView("customerInfo");

        Float cost = Float.parseFloat(allParams.get("result"));
        String productType = allParams.get("productType");
        String glassListJson = allParams.get("tableJson");
        Order order = orderService.addOrder("Active", productType, cost, glassListJson);

        modelAndView.addObject("order", order);

        return modelAndView;
    }

    @GetMapping("/all")
    public ModelAndView orders() {
        return new ModelAndView("/admin/orders");
    }

    @PostMapping("/update")
    public ModelAndView updateOrder(@ModelAttribute("order") @Validated Order order,
                                 BindingResult result, RedirectAttributes redirectAttributes) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/order/all");

        if (result.hasErrors()) {
            modelAndView.setViewName("customerInfo");
            return modelAndView;
        }

        orderService.updateOrderCustomer(order);

        return modelAndView;
    }

    @PostMapping("/alter")
    public ModelAndView alterOrder() {
        return new ModelAndView();
    }

    @PostMapping("/delete")
    public ModelAndView deleteOrder() {
        return new ModelAndView();
    }

    @PostMapping("/save")
    public ModelAndView saveOrder() {
        return new ModelAndView();
    }
}
