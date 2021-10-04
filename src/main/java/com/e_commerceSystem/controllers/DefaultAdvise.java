package com.e_commerceSystem.controllers;

import com.e_commerceSystem.exceptions.notFoundExceptions.NotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class DefaultAdvise {

    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFoundException(NotFoundException e) {

        ModelAndView modelAndView = new ModelAndView("notFound");
        modelAndView.addObject("error", e.getMessage());

        return modelAndView;
    }
}
