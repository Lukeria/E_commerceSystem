package com.e_commerceSystem.controllers;

import com.e_commerceSystem.additional.enums.ComponentType;
import com.e_commerceSystem.additional.JsonResponse;
import com.e_commerceSystem.entities.components.Accessory;
import com.e_commerceSystem.entities.components.GlassType;
import com.e_commerceSystem.entities.components.Processing;
import com.e_commerceSystem.services.ComponentServiceFactory;
import com.e_commerceSystem.services.LocaleMessageHandler;
import com.e_commerceSystem.services.interfaces.PriceListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/priceList")
public class PriceListController {

    private final ComponentServiceFactory componentServiceFactory;
    private final PriceListService priceListService;
    private final LocaleMessageHandler localeMessageHandler;

    @Autowired
    public PriceListController(ComponentServiceFactory componentServiceFactory,
                               PriceListService priceListService,
                               LocaleMessageHandler localeMessageHandler) {

        this.componentServiceFactory = componentServiceFactory;
        this.priceListService = priceListService;
        this.localeMessageHandler = localeMessageHandler;
    }

    @GetMapping("/all")
    public ModelAndView priceListAll() {

        ModelAndView modelAndView = new ModelAndView("admin/priceLists");

        List<GlassType> glassTypeList = componentServiceFactory.getComponentService(ComponentType.GLASS_TYPE).getComponentList();
        List<Processing> processingList = componentServiceFactory.getComponentService(ComponentType.PROCESSING).getComponentList();
        List<Accessory> accessoryList = componentServiceFactory.getComponentService(ComponentType.ACCESSORY).getComponentList();;

        modelAndView.addObject("glassTypeList", glassTypeList);
        modelAndView.addObject("processingList", processingList);
        modelAndView.addObject("accessoryList", accessoryList);

        return modelAndView;
    }

    @PostMapping("/")
    @ResponseBody
    public JsonResponse priceListSave(@RequestParam Map<String,String> allParams) {

        priceListService.updatePriceListGlassType(allParams.get("glassList"));
        priceListService.updatePriceListProcessing(allParams.get("processingList"));
        priceListService.updatePriceListAccessory(allParams.get("accessoryList"));

        JsonResponse response = new JsonResponse();
        response.setStatus(HttpStatus.OK);
        response.setMessage(localeMessageHandler.getMessage("message.notification.priceList.save.success"));

        return response;
    }
}
