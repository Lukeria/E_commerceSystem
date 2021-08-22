package com.e_commerceSystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthenticationController {

    @GetMapping("/loginPage")
    public ModelAndView loginPage(){
        return new ModelAndView("login");
    }

    @GetMapping("/registrationPage")
    public ModelAndView registrationPage(){
        return new ModelAndView("registration");
    }

    @PostMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("/admin/orders");
    }
//    создается с помощью Spring security

    @PostMapping("/register")
    public ModelAndView register(){
        return new ModelAndView("login");
    }

    @PostMapping("/logout")
    public ModelAndView logout(){
        return new ModelAndView("login");
    }
//    создатся с помощью Spring security

    @GetMapping("/main")
    public ModelAndView mainPage(){
        return new ModelAndView("user/main");
    }
}
