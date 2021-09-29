package com.e_commerceSystem.controllers;

import com.e_commerceSystem.additional.JsonResponse;
import com.e_commerceSystem.additional.enums.ProductType;
import com.e_commerceSystem.entities.Catalog;
import com.e_commerceSystem.entities.Order;
import com.e_commerceSystem.entities.glass.Glass;
import com.e_commerceSystem.services.JsonEditor;
import com.e_commerceSystem.services.interfaces.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;
    @Autowired
    private JsonEditor jsonEditor;

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
    public ModelAndView catalogSaveItem(@ModelAttribute Catalog catalog, @RequestParam("tableGlass") String tableGlass) {

        ModelAndView modelAndView = new ModelAndView("redirect:/catalog/settings/" + catalog.getId());

        Set<Glass> glassList = jsonEditor.parseGlassList(tableGlass);
        catalog.setGlassList(glassList);

        catalogService.updateItem(catalog);

        return modelAndView;
    }

    @PostMapping("/settings/upload")
    @ResponseBody
    public JsonResponse catalogUploadFile(@RequestParam MultipartFile file, @RequestParam ProductType productType,
                                          RedirectAttributes redirectAttributes) {

        //catalog{id}
        JsonResponse jsonResponse = new JsonResponse();

        Catalog catalog = null;
        try {
            catalog = catalogService.createItem(file, productType);
            jsonResponse.setResult(catalog.getId());
            jsonResponse.setRedirect(true);
            jsonResponse.setRedirectUrl("/catalog/settings/" + catalog.getId());
//            return catalog.getId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonResponse;
    }

    @GetMapping("/settings/displayImage")
    public void catalogAddItem(@RequestParam Long id, HttpServletResponse response)
            throws ServletException, IOException {

        Catalog catalog = catalogService.getItemById(id);
        response.setContentType("image/jpg,image/png");
        response.getOutputStream().write(catalog.getImage().getData());

        response.getOutputStream().close();
    }

    @GetMapping("/settings/{id}/updateGlass")
    public ModelAndView updateGlass(@PathVariable("id") Long id) {

        ModelAndView modelAndView = new ModelAndView("general/calculator");

        Catalog catalog = catalogService.getItemById(id);
        if (catalog.getGlassList().isEmpty()) {
            catalog.setGlassList(new HashSet<Glass>(Arrays.asList(new Glass())));
        }

        modelAndView.addObject("order", catalog);
        modelAndView.addObject("isForTemplate", true);

        return modelAndView;
    }

    @GetMapping("/settings/{id}")
    public ModelAndView updateCatalog(@PathVariable("id") Long id) {

        ModelAndView modelAndView = new ModelAndView("admin/catalog/show");

        Catalog catalog = catalogService.getItemById(id);

        modelAndView.addObject("catalog", catalog);

        return modelAndView;
    }

    @PostMapping("/settings/{id}/delete")
    public ModelAndView deleteGlass(@PathVariable("id") Long id) {

        ModelAndView modelAndView = new ModelAndView("redirect:/catalog/settings");

        Catalog catalog = catalogService.getItemById(id);
        catalogService.deleteItem(catalog);

        return modelAndView;
    }
}
