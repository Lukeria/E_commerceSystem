package com.e_commerceSystem.controllers;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Component
@RequestMapping("component")
public class ComponentController {

    @GetMapping("/")
    public ModelAndView componentMenu(){
        return new ModelAndView("/admin/componentList.jsp");
    }

    @GetMapping("/add")
    public ModelAndView componentAdd(){
        return new ModelAndView("/admin/component.jsp");
    }

    @GetMapping("/save")
    public ModelAndView componentSave(){
        return new ModelAndView("/admin/componentList.jsp");
    }

    @GetMapping("/delete")
    public ModelAndView componentDelete(){
        return new ModelAndView("/admin/componentList.jsp");
    }

    @GetMapping("/update")
    public ModelAndView componentUpdate(){
        return new ModelAndView("/admin/component.jsp");
    }
}
