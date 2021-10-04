package com.e_commerceSystem.controllers;

import com.e_commerceSystem.additional.enums.OrderStatus;
import com.e_commerceSystem.entities.Catalog;
import com.e_commerceSystem.entities.glass.Glass;
import com.e_commerceSystem.exceptions.OrderNotFoundException;
import com.e_commerceSystem.services.JsonEditor;
import com.e_commerceSystem.entities.Order;
import com.e_commerceSystem.services.interfaces.CatalogService;
import com.e_commerceSystem.services.interfaces.OrderService;
import com.e_commerceSystem.validation.OrderValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private JsonEditor jsonEditor;

    @Autowired
    private OrderValidator orderValidator;

    @InitBinder(value = "order")
    protected void initBinder(WebDataBinder binder) {

        binder.setValidator(orderValidator);
    }

    @GetMapping("/")
    public ModelAndView order() {

        return new ModelAndView("redirect:/order/all");
    }

    @GetMapping("/all")
    public ModelAndView orders() {

        ModelAndView modelAndView = new ModelAndView("/admin/orders/list");

        modelAndView.addObject("orders", orderService.getOrders());

        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView orderAdd() {

        ModelAndView modelAndView = new ModelAndView("redirect:/calculator/");

        return modelAndView;
    }

    @GetMapping(value = "/{id}")
    public ModelAndView showOrder(@PathVariable("id") Long id,
                                  @ModelAttribute("message") String message,
                                  @ModelAttribute("status") String status) {


        ModelAndView modelAndView = new ModelAndView("/admin/orders/show");

        Order order = orderService.getOrderById(id);

        modelAndView.addObject("order", order);
        modelAndView.addObject("message", message);
        modelAndView.addObject("status", status);


        return modelAndView;
    }

    @GetMapping(value = "/{id}/close")
    //jquery post
    public ModelAndView closeOrder(@PathVariable("id") Long id) {

        ModelAndView modelAndView = new ModelAndView("redirect:/order/" + id);

        orderService.updateOrderStatus(id, OrderStatus.CLOSED);

        return modelAndView;
    }

    @PostMapping("/{id}/delete")
    //jquery
    public ModelAndView deleteOrder(@PathVariable("id") Long id) {

        ModelAndView modelAndView = new ModelAndView("redirect:/order/all");

        orderService.deleteOrder(id);

        return modelAndView;
    }

    @GetMapping("/{id}/update")
    public ModelAndView updateOrder(@PathVariable("id") Long id,
                                    final RedirectAttributes redirectAttributes) {

        ModelAndView modelAndView = new ModelAndView();

        Order order = orderService.getOrderById(id);

        if (order.getStatus() == OrderStatus.CLOSED) {

            modelAndView.setViewName("redirect:/order/" + id);
            redirectAttributes.addFlashAttribute("message", "Updating closed orders is not allowed");
            redirectAttributes.addFlashAttribute("status", "danger");

        } else {

            modelAndView.setViewName("redirect:/calculator/");
            redirectAttributes.addFlashAttribute("order", order);
        }

        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveOrder(@ModelAttribute("order") @Validated Order order,
                                  BindingResult result,
                                  @RequestParam("tableGlass") String tableGlass,
                                  HttpServletRequest request, RedirectAttributes redirectAttributes) {

        ModelAndView modelAndView = new ModelAndView();

        Set<Glass> glassList = jsonEditor.parseGlassList(tableGlass);
        order.setGlassList(glassList);

        if (result.hasErrors()) {
            modelAndView.addObject("order", order);
            modelAndView.setViewName("general/calculator");
            return modelAndView;
        }

        order.setStatus(OrderStatus.ACTIVE);

        if (order.isNew()) {
            orderService.addOrder(order);
            modelAndView.setViewName("redirect:/customer/add");
            redirectAttributes.addFlashAttribute("orderId", order.getId());
//            redirectAttributes.addFlashAttribute("orderId", order.getId());
//            redirectAttributes.addFlashAttribute("customer", new Customer());
        } else {
            orderService.updateOrder(order);
            modelAndView.setViewName("redirect:/order/" + order.getId());
        }

        return modelAndView;
    }


}
