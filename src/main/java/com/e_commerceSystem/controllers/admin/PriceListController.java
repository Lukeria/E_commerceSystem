package com.e_commerceSystem.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/priceList")
public class PriceListController {

//    @GetMapping("/")
//    //открываем каждый прайс, использовать PathVariable, либо все на одной странице
//    public ModelAndView priceList(){
//        return new ModelAndView();
//    }5

    @GetMapping("/all")
    public ModelAndView priceListAll(){
        return new ModelAndView("admin/priceLists");
    }

    @PostMapping("/addItem")
    public ModelAndView priceListAddItem(){
        return new ModelAndView();
    }

    @PostMapping("/alterItem")
    public ModelAndView priceListAlterItem(){
        return new ModelAndView();
    }

    @PostMapping("/deleteItem")
    public ModelAndView priceListDeleteItem(){
        return new ModelAndView();
    }

}
