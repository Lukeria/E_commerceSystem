package com.e_commerceSystem.controllers;

import com.e_commerceSystem.additional.ComponentViews;
import com.e_commerceSystem.additional.JsonResponse;
import com.e_commerceSystem.entities.components.Accessory;
import com.e_commerceSystem.entities.glass.Glass;
import com.e_commerceSystem.entities.glass.GlassType;
import com.e_commerceSystem.entities.glass.Processing;
import com.e_commerceSystem.services.interfaces.ComponentService;
import com.e_commerceSystem.services.interfaces.PriceListService;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/priceList")
public class PriceListController {

    //    @GetMapping("/")
//    //открываем каждый прайс, использовать PathVariable, либо все на одной странице
//    public ModelAndView priceList(){
//        return new ModelAndView();
//    }5
    @Autowired
    private ComponentService componentService;
    @Autowired
    private PriceListService priceListService;

    @GetMapping("/all")
    public ModelAndView priceListAll() {

        ModelAndView modelAndView = new ModelAndView("admin/priceLists");

        List<GlassType> glassTypeList = componentService.getGlassTypeList();
        List<Processing> processingList = componentService.getProcessingList();
        List<Accessory> accessoryList = componentService.getAccessoryList();

        modelAndView.addObject("glassTypeList", glassTypeList);
        modelAndView.addObject("processingList", processingList);
        modelAndView.addObject("accessoryList", accessoryList);

        return modelAndView;
    }

    @PostMapping("/save")
    @ResponseBody
    @JsonView(ComponentViews.PriceList.class)
    public JsonResponse priceListSave(@RequestParam Map<String,String> allParams) {

        priceListService.updatePriceListGlassType(allParams.get("tableJsonGlass"));

        JsonResponse response = new JsonResponse();
        response.setStatus("SUCCESS");
        response.setResult("");

        return response;
    }

//    @PostMapping("/alterItem")
//    public ModelAndView priceListAlterItem() {
//        return new ModelAndView();
//    }
//
//    @PostMapping("/deleteItem")
//    public ModelAndView priceListDeleteItem() {
//        return new ModelAndView();
//    }

}
