package com.e_commerceSystem.controllers;

import com.e_commerceSystem.additional.enums.ProductType;
import com.e_commerceSystem.entities.Catalog;
import com.e_commerceSystem.services.interfaces.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    @GetMapping("/")
    public ModelAndView catalog() {
        return new ModelAndView("redirect:/catalog/mirror");
    }

    @GetMapping("/{productType}")
    public ModelAndView catalogProductType(@PathVariable ProductType productType) {

        ModelAndView modelAndView = new ModelAndView("user/catalog");
        modelAndView.addObject("productType", productType);

        return modelAndView;
    }

    @GetMapping("/settings")
    public ModelAndView catalogSettings() {

        ModelAndView modelAndView = new ModelAndView("admin/catalog/settings");
        modelAndView.addObject("productTypes", ProductType.values());
        modelAndView.addObject("listOfItems", catalogService.getItemsByProductType("mirror"));

        return modelAndView;
    }

    @GetMapping("/settings/add")
    public ModelAndView catalogAddItem() {

        ModelAndView modelAndView = new ModelAndView("admin/catalog/add");
        modelAndView.addObject("productTypes", ProductType.values());

        return modelAndView;
    }

    @PostMapping("/settings/save")
    public ModelAndView catalogSaveItem(@RequestParam ProductType productType) {

        ModelAndView modelAndView = new ModelAndView("admin/catalog/settings");

        return modelAndView;
    }

    //    @PostMapping("/settings/upload")
    @RequestMapping(value = "/settings/upload", method = RequestMethod.POST, headers = ("content-type=multipart/*"), consumes = "image/*")
    @ResponseBody
    public Long catalogUploadFile(@RequestParam MultipartFile file) {

        ModelAndView modelAndView = new ModelAndView("admin/catalog/settings");
        Catalog catalog = null;
        try {
            catalog = catalogService.createItem(file);
            return catalog.getId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/settings/displayImage")
    public void catalogAddItem(@RequestParam Long id, HttpServletResponse response)
            throws ServletException, IOException {

        Catalog catalog = catalogService.getItemById(id);
        response.setContentType("image/jpg,image/png");
        response.getOutputStream().write(catalog.getImage().getData());

        response.getOutputStream().close();
    }
}
