package com.e_commerceSystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/catalog")
public class CatalogController {

    @GetMapping("/")
    public ModelAndView catalog(){
        return new ModelAndView("catalog");
    }

    @GetMapping("/settings")
    public ModelAndView eCommerceManagement(){
        return new ModelAndView("catalogSettings");
    }
}
