package com.e_commerceSystem.controllers;

import com.e_commerceSystem.additional.ComponentViews;
import com.e_commerceSystem.additional.JsonResponse;
import com.e_commerceSystem.entities.glass.GlassType;
import com.e_commerceSystem.entities.glass.Processing;
import com.e_commerceSystem.services.interfaces.ComponentService;
import com.e_commerceSystem.services.interfaces.CalculatorService;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.*;
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
        return modelAndView;

    }

    @PostMapping("/calculate")
    @ResponseBody
    @JsonView(ComponentViews.Normal.class)
    public JsonResponse calculateAjax(@RequestParam Map<String,String> allParams){

        float resultPrice = calculatingService.calculatePrice(allParams.get("tableJSON"));

        JsonResponse response = new JsonResponse();
        response.setStatus("SUCCESS");
        response.setResult(resultPrice);

       return response;
    }

}
