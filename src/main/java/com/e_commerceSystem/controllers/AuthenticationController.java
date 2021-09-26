package com.e_commerceSystem.controllers;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthenticationController {

    @GetMapping("/login")
    public ModelAndView loginPage(){
        return new ModelAndView("login");
    }

    @GetMapping("/signUp")
    public ModelAndView registrationPage(){
        return new ModelAndView("registration");
    }

//    @PostMapping("/loginAction")
//    public ModelAndView perform_login(){
//        return new ModelAndView("/admin/orders");
//    }
//    создается с помощью Spring security

    @PostMapping("/register")
    public ModelAndView register(){

        return new ModelAndView("login");
    }

//    @PostMapping("/logout")
//    public ModelAndView logout(){
//        return new ModelAndView("login");
//    }
//    создатся с помощью Spring security

    @GetMapping("/main")
    public ModelAndView mainPage(){
        return new ModelAndView("user/main");
    }
}
