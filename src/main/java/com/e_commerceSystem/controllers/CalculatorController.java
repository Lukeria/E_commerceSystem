package com.e_commerceSystem.controllers;

import com.e_commerceSystem.additional.JsonResponse;
import com.e_commerceSystem.additional.enums.ProductType;
import com.e_commerceSystem.additional.enums.Shape;
import com.e_commerceSystem.entities.Catalog;
import com.e_commerceSystem.entities.Order;
import com.e_commerceSystem.services.interfaces.CalculatorService;
import com.e_commerceSystem.services.interfaces.CatalogService;
import com.e_commerceSystem.services.interfaces.OrderService;
import com.e_commerceSystem.validation.GlassValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatingService;
    private final OrderService orderService;
    private final CatalogService catalogService;
    private final GlassValidator glassValidator;

    @Autowired
    public CalculatorController(CalculatorService calculatingService,
                                OrderService orderService,
                                CatalogService catalogService,
                                GlassValidator glassValidator) {

        this.calculatingService = calculatingService;
        this.orderService = orderService;
        this.catalogService = catalogService;
        this.glassValidator = glassValidator;
    }

    @GetMapping("/")
    public ModelAndView calculator(@RequestParam(name = "productType", required = false) ProductType productType,
                                   @ModelAttribute("order") Order order,
                                   @ModelAttribute("catalog") Catalog catalog,
                                   @ModelAttribute("isTemplate") Boolean isTemplate,
                                   @ModelAttribute("message") String message) {

        ModelAndView modelAndView = new ModelAndView("general/calculator");

        if (isTemplate) {
            catalogService.prepareForView(catalog, productType);
            modelAndView.addObject("model", catalog);
        } else {
            modelAndView.addObject("model", order);
        }
        modelAndView.addObject("isForTemplate", isTemplate);
        modelAndView.addObject("message", message);
        modelAndView.addObject("productTypes", ProductType.values());
        modelAndView.addObject("shapes", Shape.values());

        return modelAndView;

    }

    @PostMapping("/calculate")
    @ResponseBody
    public JsonResponse calculate(@RequestBody Order order) {

        float resultPrice = calculatingService.calculatePrice(order);

        JsonResponse response = new JsonResponse();
        response.setStatus(HttpStatus.OK);
        response.setResult(resultPrice);

        return response;
    }

    @ModelAttribute("order")
    public void prepareOrder(Order order, ProductType productType){

        if(order.isNew()){
            orderService.prepareForView(order, productType);
        }
    }

    @ModelAttribute("isTemplate")
    public void prepareOrder(Model model){

        model.addAttribute("isTemplate", Boolean.FALSE);
    }

}
