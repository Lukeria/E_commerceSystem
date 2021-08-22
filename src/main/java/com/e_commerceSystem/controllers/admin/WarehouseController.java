package com.e_commerceSystem.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/warehouse")
public class WarehouseController {

    @GetMapping("/")
    public ModelAndView warehouse(){
        return new ModelAndView("warehouse");
    }

    @PostMapping("/increaseAmount")
    public ModelAndView warehouseIncreaseAmount(){
        return new ModelAndView("warehouse");
    }

    @GetMapping("/decreaseAmount")
    public ModelAndView warehouseDecreaseAmount(){
        return new ModelAndView("warehouse");
    }

}
