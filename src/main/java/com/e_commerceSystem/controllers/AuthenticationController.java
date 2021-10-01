package com.e_commerceSystem.controllers;

import com.e_commerceSystem.entities.User;
import com.e_commerceSystem.exceptions.UserAlreadyExistsException;
import com.e_commerceSystem.services.UserServiceImp;
import com.e_commerceSystem.services.interfaces.UserService;
import com.e_commerceSystem.validation.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.WebParam;

@Controller
public class AuthenticationController {

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UserService userService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(userValidator);
    }

    @GetMapping("/login")
    public ModelAndView loginPage(RedirectAttributes redirectAttributes) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("general/login");
        return modelAndView;
    }

    @GetMapping("/signUp")
    public ModelAndView signUpPage() {

        ModelAndView modelAndView = new ModelAndView("general/registration");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/signUp")
    public ModelAndView signUp(@ModelAttribute @Validated User user, BindingResult result) {

        ModelAndView modelAndView = new ModelAndView();

        if (result.hasErrors()) {
            modelAndView.addObject("user", user);
            modelAndView.setViewName("general/registration");
            return modelAndView;
        }

        try {
            userService.registerNewUser(user);
        } catch (UserAlreadyExistsException exception){
            result.rejectValue("email", "message.alreadyExists.user.email");
            modelAndView.addObject("user", user);
            modelAndView.setViewName("general/registration");
            return modelAndView;
        }

        modelAndView.setViewName("redirect:/login");

        return modelAndView;
    }

}
