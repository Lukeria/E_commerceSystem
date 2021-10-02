package com.e_commerceSystem.controllers;

import com.e_commerceSystem.additional.enums.OrderStatus;
import com.e_commerceSystem.entities.Catalog;
import com.e_commerceSystem.entities.glass.Glass;
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

    @InitBinder
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
    public ModelAndView showOrder(@PathVariable("id") Long id) {

        ModelAndView modelAndView = new ModelAndView("/admin/orders/show");

        Order order = orderService.getOrderById(id);
        if (order == null) {
//            modelAndView.addObject("css", "danger");
//            modelAndView.addObject("msg", "Order not found");
        }

        modelAndView.addObject("order", order);

        return modelAndView;

    }

    @PostMapping(value = "/{id}")
    public ModelAndView showOrderPost(@PathVariable("id") Long id) {
        return showOrder(id);
    }

    @GetMapping(value = "/{id}/close")
    public ModelAndView closeOrder(@PathVariable("id") Long id, final RedirectAttributes redirectAttributes) {

        ModelAndView modelAndView = new ModelAndView("redirect:/order/" + id);

        Order order = orderService.getOrderById(id);
        if (order == null) {
//            redirectAttributes.addAttribute("css", "danger");
//            redirectAttributes.addAttribute("msg", "Error while closing order");
        } else {
            order.setStatus(OrderStatus.CLOSED);
            orderService.updateOrderStatus(order);
//
//            redirectAttributes.addAttribute("css", "success");
//            redirectAttributes.addAttribute("msg", "Order closed successfully");
        }

        return modelAndView;

    }

    @PostMapping("/{id}/delete")
    public ModelAndView deleteOrder(@PathVariable("id") Long id, final RedirectAttributes redirectAttributes) {

        ModelAndView modelAndView = new ModelAndView("redirect:/order/all");

        Order order = orderService.getOrderById(id);
        if (order == null) {
//            redirectAttributes.addAttribute("css", "danger");
//            redirectAttributes.addAttribute("msg", "Error while deleting order");
        } else {
            orderService.deleteOrder(order);
//            redirectAttributes.addAttribute("css", "success");
//            redirectAttributes.addAttribute("msg", "Order deletes successfully");
        }
        return modelAndView;
    }

    @GetMapping("/{id}/update")
    public ModelAndView updateOrder(@PathVariable("id") Long id, final RedirectAttributes redirectAttributes) {

        ModelAndView modelAndView = new ModelAndView("general/calculator");

        Order order = orderService.getOrderById(id);
        modelAndView.addObject("order", order);

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
