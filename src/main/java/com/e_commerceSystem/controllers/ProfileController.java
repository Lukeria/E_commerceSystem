package com.e_commerceSystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @GetMapping("/")
    public ModelAndView profile(){
        return new ModelAndView("general/profile");
    }

    @GetMapping("/save")
    public ModelAndView saveProfile(){
        return new ModelAndView("general/profile");
    }

}
