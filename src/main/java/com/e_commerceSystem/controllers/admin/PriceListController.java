package com.e_commerceSystem.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PriceListController {

    @GetMapping("/priceLists")
    public ModelAndView priceList(){
        return new ModelAndView("priceLists");
    }
}
