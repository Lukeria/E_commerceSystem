package com.e_commerceSystem.controllers;

import com.e_commerceSystem.additional.ComponentTypes;
import com.e_commerceSystem.additional.ComponentViews;
import com.e_commerceSystem.additional.JsonResponse;
import com.e_commerceSystem.entities.components.Accessory;
import com.e_commerceSystem.entities.glass.GlassType;
import com.e_commerceSystem.entities.glass.Processing;
import com.e_commerceSystem.services.ComponentServiceFactory;
import com.e_commerceSystem.services.interfaces.PriceListService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
    private ComponentServiceFactory componentServiceFactory;
    @Autowired
    private PriceListService priceListService;

    @GetMapping("/all")
    public ModelAndView priceListAll() {

        ModelAndView modelAndView = new ModelAndView("admin/priceLists");

        List<GlassType> glassTypeList = componentServiceFactory.getComponentService(ComponentTypes.GLASS_TYPE).getComponentList();
        List<Processing> processingList = componentServiceFactory.getComponentService(ComponentTypes.PROCESSING).getComponentList();
        List<Accessory> accessoryList = componentServiceFactory.getComponentService(ComponentTypes.PROCESSING).getComponentList();;

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
        priceListService.updatePriceListProcessing(allParams.get("tableJsonProcessing"));
        priceListService.updatePriceListAccessory(allParams.get("tableJsonAccessory"));

        JsonResponse response = new JsonResponse();
        response.setStatus("SUCCESS");
        response.setResult("");

        return response;
    }
}
