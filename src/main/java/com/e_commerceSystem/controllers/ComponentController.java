package com.e_commerceSystem.controllers;

import com.e_commerceSystem.additional.JsonResponse;
import com.e_commerceSystem.entities.components.Accessory;
import com.e_commerceSystem.entities.glass.GlassType;
import com.e_commerceSystem.entities.glass.Processing;
import com.e_commerceSystem.services.interfaces.ComponentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Component
@RequestMapping("/component")
public class ComponentController {

    @Autowired
    private ComponentService componentService;

    @GetMapping("/")
    public ModelAndView componentMenu() {

        ModelAndView modelAndView = new ModelAndView("admin/componentList");

        List<GlassType> glassTypeList = componentService.getGlassTypeList();
        List<Processing> processingList = componentService.getProcessingList();
        List<Accessory> accessoryList = componentService.getAccessoryList();

        modelAndView.addObject("glassTypeList", glassTypeList);
        modelAndView.addObject("processingList", processingList);
        modelAndView.addObject("accessoryList", accessoryList);

        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView componentAdd() {

        return new ModelAndView("/admin/component");
    }

    @PostMapping("/save")
    public ModelAndView componentSave(@RequestParam Map<String, String> allParams) {

        ModelAndView modelAndView = new ModelAndView("redirect:/component/");

        String type="";
        String name = "";
        Integer thickness = 0;
        String symbol = "";

        for (Map.Entry<String, String> entry : allParams.entrySet()) {
            if(entry.getKey().equals("componentType")){
                type = entry.getValue();
            } else if (entry.getKey().equals("name")){
                name = entry.getValue();
            } else if (entry.getKey().equals("thickness")){
                try {
                    thickness = Integer.parseInt(entry.getValue());
                }catch (NumberFormatException e){
                    e.printStackTrace();
                }
            } else if (entry.getKey().equals("symbol")){
                symbol = entry.getValue();
            }
        }

        if(type.equals("glassType")){
            componentService.addGlassType(name, thickness);
        }else if(type.equals("processing")){
           componentService.addProcessing(name, symbol);
        }else if(type.equals("accessory")){
           componentService.addAccessory(name);
        }

        return modelAndView;
    }

    @GetMapping("/delete")
    public ModelAndView componentDelete() {
        return new ModelAndView("/admin/componentList");
    }

    @GetMapping("/update")
    public ModelAndView componentUpdate() {
        return new ModelAndView("/admin/component");
    }

    @PostMapping("/getData")
    @ResponseBody
    public JsonResponse getListData(){

        List<GlassType> glassTypeList = componentService.getGlassTypeList();
        List<Processing> processingList = componentService.getProcessingList();

        ObjectMapper mapper = new ObjectMapper();
        String jsonGlassTypeList = "";
        String jsonProcessing = "";
        try {
            jsonGlassTypeList = mapper.writeValueAsString(glassTypeList);
            jsonProcessing = mapper.writeValueAsString(processingList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String result = "{\"glassTypeList\":"+jsonGlassTypeList+", \"processingList\":" + jsonProcessing +"}";
        JsonResponse response = new JsonResponse();
        response.setStatus("SUCCESS");
        response.setResult(result);

        return response;
    }
}
