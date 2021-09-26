package com.e_commerceSystem.controllers;

import com.e_commerceSystem.additional.ComponentViews;
import com.e_commerceSystem.additional.JsonResponse;
import com.e_commerceSystem.entities.Order;
import com.e_commerceSystem.entities.glass.Glass;
import com.e_commerceSystem.services.interfaces.CalculatorService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatingService;

    @GetMapping("/")
    public ModelAndView calculator() {

        ModelAndView modelAndView = new ModelAndView("calculator");

        Order order = new Order();
        List<Glass> glassList = new ArrayList<Glass>();
        glassList.add(new Glass());
        order.setGlassList(new HashSet<>(glassList));

        modelAndView.addObject("order", order);
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

}
