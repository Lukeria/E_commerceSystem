package com.e_commerceSystem.controllers;

import com.e_commerceSystem.entities.items.Glass;
import com.e_commerceSystem.service_interface.ItemService;
import com.e_commerceSystem.service_interface.PriceCalculatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {

    @Autowired
    PriceCalculatingService calculatingService;
    @Autowired
    ItemService itemService;

    @GetMapping("/")
    public ModelAndView calculator(){

        ModelAndView modelAndView = new ModelAndView("calculator");
        List<Glass> glassList = itemService.getGlassList();
        modelAndView.addObject("glassList", glassList);

        return modelAndView;
    }

    @PostMapping("/calculate")
    public ModelAndView calculate(@RequestParam Map<String,String> allParams){

        ModelAndView modelAndView = new ModelAndView("calculator");

        float result = calculatingService.calculatePrice(allParams);

        modelAndView.addAllObjects(allParams);
        modelAndView.addObject("result", result);

        return modelAndView;
    }


}
