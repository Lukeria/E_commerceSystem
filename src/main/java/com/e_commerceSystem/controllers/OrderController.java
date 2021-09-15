package com.e_commerceSystem.controllers;

import com.e_commerceSystem.entities.glass.Glass;
import com.e_commerceSystem.services.JsonEditor;
import com.e_commerceSystem.entities.Customer;
import com.e_commerceSystem.entities.Order;
import com.e_commerceSystem.services.interfaces.OrderService;
import com.e_commerceSystem.validation.OrderValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
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

        modelAndView.addObject("activeOrders", orderService.getOrdersByStatus("Active"));
        modelAndView.addObject("closedOrders", orderService.getOrdersByStatus("Closed"));

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
            order.setStatus("Closed");
            orderService.updateOrder(order);
//
//            redirectAttributes.addAttribute("css", "success");
//            redirectAttributes.addAttribute("msg", "Order closed successfully");
        }

        modelAndView.addObject("order", order);

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

        ModelAndView modelAndView = new ModelAndView("calculator");

        Order order = orderService.getOrderById(id);
        modelAndView.addObject("order", order);

        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveOrder(@ModelAttribute("order") @Validated Order order,
                                    @RequestParam("tableGlass") String tableGlass,
                                    BindingResult result,
                                    HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView();
        Set<Glass> glassList = jsonEditor.parseGlassList(tableGlass);
        order.setGlassList(glassList);
        order.setStatus("Active");

        if(order.isNew()){
            orderService.addOrder(order);
            modelAndView.setViewName("forward:/customer/add");
            request.setAttribute("orderId", order.getId());
//            redirectAttributes.addFlashAttribute("orderId", order.getId());
//            redirectAttributes.addFlashAttribute("customer", new Customer());
        } else{
            orderService.updateOrder(order);
            modelAndView.setViewName("redirect:/order/"+order.getId());
        }

        return modelAndView;
    }

    @PostMapping("/saveOrderCustomer")
    public ModelAndView saveOrderCustomer(@ModelAttribute("customer") @Validated Customer customer,
                                          @RequestParam("orderId") Long orderId,
                                          BindingResult result, RedirectAttributes redirectAttributes) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/order/"+orderId);

        if (result.hasErrors()) {
//            modelAndView.setViewName("customerInfo");
//            return modelAndView;
        }

        Order order = orderService.getOrderById(orderId);
        order.setCustomer(customer);
        orderService.updateOrderCustomer(order);

        return modelAndView;
    }

}
