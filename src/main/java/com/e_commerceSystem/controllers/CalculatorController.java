package com.e_commerceSystem.controllers;

import com.e_commerceSystem.additional.ComponentViews;
import com.e_commerceSystem.additional.JsonResponse;
import com.e_commerceSystem.additional.enums.ProductType;
import com.e_commerceSystem.entities.Catalog;
import com.e_commerceSystem.entities.Order;
import com.e_commerceSystem.entities.glass.Glass;
import com.e_commerceSystem.services.interfaces.CalculatorService;
import com.e_commerceSystem.services.interfaces.CatalogService;
import com.e_commerceSystem.services.interfaces.OrderService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatingService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private CatalogService catalogService;

    @GetMapping("/")
    public ModelAndView calculator(@RequestParam(name = "productType", required = false) ProductType productType,
                                   @ModelAttribute("order") Order order,
                                   @ModelAttribute("catalog") Catalog catalog,
                                   @ModelAttribute("isTemplate") Boolean isTemplate,
                                   @ModelAttribute("message") String message) {

        ModelAndView modelAndView = new ModelAndView("general/calculator");

        if (isTemplate) {
            catalogService.prepareForView(catalog, productType);
            modelAndView.addObject("order", catalog);
        } else {
            modelAndView.addObject("order", order);
        }
        modelAndView.addObject("isForTemplate", isTemplate);
        modelAndView.addObject("message", message);
        modelAndView.addObject("productTypes", ProductType.values());

        return modelAndView;

    }

    @PostMapping("/calculate")
    @ResponseBody
    @JsonView(ComponentViews.Normal.class)
    public JsonResponse calculate(@RequestBody List<Glass> glassList) {

        float resultPrice = calculatingService.calculatePrice(glassList);

        JsonResponse response = new JsonResponse();
        response.setStatus("SUCCESS");
        response.setResult(resultPrice);

        return response;
    }

    @GetMapping("/fillByCatalog/{id}")
    public ModelAndView createOrderByTemplate(@PathVariable("id") Long id) {

        ModelAndView modelAndView = new ModelAndView("general/calculator");

        Catalog catalog = catalogService.getItemById(id);
        Order order = orderService.createOrder(catalog);

        modelAndView.addObject("order", order);

        return modelAndView;
    }

    @ModelAttribute("order")
    public void prepareOrder(Order order, ProductType productType){

        if(order.isNew()){
            orderService.prepareForView(order, productType);
        }
    }

    @ModelAttribute("isTemplate")
    public void prepareOrder(Model model){

        model.addAttribute("isTemplate", new Boolean(false));
    }

}
