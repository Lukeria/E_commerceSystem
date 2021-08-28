package com.e_commerceSystem.controllers;

import com.e_commerceSystem.entities.components.GlassType;
import com.e_commerceSystem.services.interfaces.ComponentService;
import com.e_commerceSystem.services.interfaces.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
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
    CalculatorService calculatingService;
    @Autowired
    ComponentService componentService;

    @GetMapping("/")
    public ModelAndView calculator(){

        ModelAndView modelAndView = new ModelAndView("calculator");
        List<GlassType> glassTypeList = componentService.getGlassTypeList();
        modelAndView.addObject("glassTypeList", glassTypeList);

        return modelAndView;
    }

    @PostMapping("/calculate")
    public ModelAndView calculate(@RequestParam Map<String,String> allParams){

        ModelAndView modelAndView = new ModelAndView("calculator");

        GlassType glassType = new GlassType();
        glassType.setName("Лакомат");
        glassType.setThickness(4);

        componentService.addGlassType(glassType);

        float result = calculatingService.calculatePrice(allParams);

        modelAndView.addAllObjects(allParams);
        modelAndView.addObject("result", result);

        return modelAndView;
    }


}
