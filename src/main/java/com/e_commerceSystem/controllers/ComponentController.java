package com.e_commerceSystem.controllers;

import com.e_commerceSystem.additional.enums.ComponentType;
import com.e_commerceSystem.additional.JsonResponse;
import com.e_commerceSystem.additional.enums.ProcessingType;
import com.e_commerceSystem.entities.components.DefaultComponent;
import com.e_commerceSystem.entities.glass.GlassType;
import com.e_commerceSystem.entities.glass.Processing;
import com.e_commerceSystem.services.ComponentServiceFactory;
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
    private ComponentServiceFactory componentServiceFactory;

    @GetMapping("/")
    public ModelAndView componentMain() {

        ModelAndView modelAndView = new ModelAndView("admin/components/main");
        return modelAndView;
    }


    @GetMapping("{componentType}/all")
    public ModelAndView componentList(@PathVariable ComponentType componentType) {

        ModelAndView modelAndView = new ModelAndView("admin/components/list");

        ComponentService componentService = componentServiceFactory.getComponentService(componentType);
        if (componentService != null) {
            modelAndView.addObject("componentList", componentService.getComponentList());
            modelAndView.addObject("componentType", componentType);
        }

        return modelAndView;
    }

    @GetMapping("{componentType}/add")
    public ModelAndView componentAdd(@PathVariable ComponentType componentType) {

        ModelAndView modelAndView = new ModelAndView("/admin/components/add");

        ComponentService componentService = componentServiceFactory.getComponentService(componentType);

        modelAndView.addObject("component", componentService.getEmptyComponent());
        modelAndView.addObject("processingTypes", ProcessingType.values());
        return modelAndView;
    }

    @PostMapping("{componentType}/save")
    public ModelAndView componentSave(@PathVariable ComponentType componentType,
                                      @RequestParam Map<String, String> allParams) {

        ModelAndView modelAndView = new ModelAndView("redirect:/component/"+componentType.getName()+"/all");

        ComponentService componentService = componentServiceFactory.getComponentService(componentType);
        DefaultComponent component = componentService.extractComponentFromRequest(allParams);
        if(component.isNew()){
            componentService.addComponent(component);
        } else {
            componentService.updateComponent(component);
        }

        return modelAndView;
    }

    @PostMapping("{componentType}/{id}/delete")
    public ModelAndView componentDelete(@PathVariable ComponentType componentType, @PathVariable Long id) {

        ModelAndView modelAndView = new ModelAndView("redirect:/component/" + componentType.getName() + "/all");
        ComponentService componentService = componentServiceFactory.getComponentService(componentType);
        if (componentService != null) {
            componentService.deleteComponent(componentService.getComponentById(id));
        }
        return modelAndView;
    }

    @GetMapping("{componentType}/{id}/update")
    public ModelAndView componentUpdate(@PathVariable ComponentType componentType, @PathVariable Long id) {

        ModelAndView modelAndView = new ModelAndView("/admin/components/add");

        ComponentService componentService = componentServiceFactory.getComponentService(componentType);

        modelAndView.addObject("component", componentService.getComponentById(id));
        modelAndView.addObject("processingTypes", ProcessingType.values());

        return modelAndView;
    }

    @PostMapping("/getData")
    @ResponseBody
    public JsonResponse getListData() {

        List<GlassType> glassTypeList = componentServiceFactory.getComponentService(ComponentType.GLASS_TYPE).getComponentList();
        List<Processing> processingList = componentServiceFactory.getComponentService(ComponentType.PROCESSING).getComponentList();

        ObjectMapper mapper = new ObjectMapper();
        String jsonGlassTypeList = "";
        String jsonProcessing = "";
        try {
            jsonGlassTypeList = mapper.writeValueAsString(glassTypeList);
            jsonProcessing = mapper.writeValueAsString(processingList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String result = "{\"glassTypeList\":" + jsonGlassTypeList + ", \"processingList\":" + jsonProcessing + "}";
        JsonResponse response = new JsonResponse();
        response.setStatus("SUCCESS");
        response.setResult(result);

        return response;
    }

}
