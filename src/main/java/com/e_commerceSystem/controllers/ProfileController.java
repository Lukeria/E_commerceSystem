package com.e_commerceSystem.controllers;

import com.e_commerceSystem.additional.CustomUserDetails;
import com.e_commerceSystem.entities.Customer;
import com.e_commerceSystem.entities.User;
import com.e_commerceSystem.services.interfaces.CustomerService;
import com.e_commerceSystem.validation.CustomerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    private final CustomerService customerService;
    private final CustomerValidator customerValidator;

    @Autowired
    public ProfileController(CustomerService customerService,
                             CustomerValidator customerValidator) {
        this.customerService = customerService;
        this.customerValidator = customerValidator;
    }

    @InitBinder(value = "customer")
    protected void initBinder(WebDataBinder binder) {

        binder.setValidator(customerValidator);
    }

    @GetMapping("/")
    public ModelAndView profile(Authentication authentication){

        ModelAndView modelAndView =  new ModelAndView("user/profile");

        User currentUser = ((CustomUserDetails) authentication.getPrincipal()).getUser();

        modelAndView.addObject("customer",currentUser.getCustomer());
        modelAndView.addObject("username", currentUser.getUsername());

        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveProfile(@ModelAttribute("customer") @Validated Customer customer,
                                    BindingResult result,
                                    Authentication authentication){

        ModelAndView modelAndView = new ModelAndView();

        if(result.hasErrors()){
            modelAndView.setViewName("user/profile");
            return modelAndView;
        }

        customerService.update(customer, authentication);

        modelAndView.setViewName("redirect:/profile/");

        return modelAndView;
    }

}
