package com.e_commerceSystem.controllers;

import com.e_commerceSystem.entities.Order;
import com.e_commerceSystem.services.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    public ModelAndView order() {
        return new ModelAndView("redirect:/order/all");
    }

    @GetMapping("/all")
    public ModelAndView orders() {

        ModelAndView modelAndView = new ModelAndView("/admin/orders");

        modelAndView.addObject("activeOrders", orderService.getOrdersByStatus("Active"));
        modelAndView.addObject("closedOrders", orderService.getOrdersByStatus("Closed"));

        return modelAndView;
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
