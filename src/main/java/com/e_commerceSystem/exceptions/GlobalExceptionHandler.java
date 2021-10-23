package com.e_commerceSystem.exceptions;

import com.e_commerceSystem.exceptions.notFoundExceptions.NotFoundException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFoundException(NotFoundException e) {

        ModelAndView modelAndView = new ModelAndView("notFound");
        modelAndView.addObject("error", e.getMessage());
        modelAndView.addObject("status", 404);

        return modelAndView;
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handleNoHandlerFoundException(NoHandlerFoundException e) {

        ModelAndView modelAndView = new ModelAndView("notFound");
        modelAndView.addObject("error", e.getMessage());
        modelAndView.addObject("status", 404);

        return modelAndView;
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ModelAndView handleHttpRequestMethodNotSupportedException(NoHandlerFoundException e) {

        ModelAndView modelAndView = new ModelAndView("notFound");
        modelAndView.addObject("error", e.getMessage());
        modelAndView.addObject("status", 405);

        return modelAndView;
    }
}
