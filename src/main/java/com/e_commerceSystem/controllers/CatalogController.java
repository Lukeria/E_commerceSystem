package com.e_commerceSystem.controllers;

import com.e_commerceSystem.additional.JsonResponse;
import com.e_commerceSystem.additional.enums.ProductType;
import com.e_commerceSystem.entities.Catalog;
import com.e_commerceSystem.entities.Order;
import com.e_commerceSystem.entities.glass.Glass;
import com.e_commerceSystem.services.JsonEditor;
import com.e_commerceSystem.services.interfaces.CatalogService;
import com.e_commerceSystem.validation.CatalogValidator;
import com.sun.javafx.iio.ImageStorageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    @Autowired
    private JsonEditor jsonEditor;

    @Autowired
    private CatalogValidator catalogValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(catalogValidator);
    }

    @GetMapping("/")
    public ModelAndView catalog() {

        return new ModelAndView("redirect:/catalog/mirror");
    }

    @GetMapping("/{productType}")
    public ModelAndView catalogByProductType(@PathVariable ProductType productType) {

        ModelAndView modelAndView = new ModelAndView("user/catalog");
        modelAndView.addObject("productType", productType);
        modelAndView.addObject("listOfItems", catalogService.getItemsByProductType(productType));

        return modelAndView;
    }

    @GetMapping("/settings")
    public ModelAndView catalogSettings(@RequestParam(defaultValue = "mirror") ProductType productType) {

        ModelAndView modelAndView = new ModelAndView("admin/catalog/settings");
        defineFormData(modelAndView);

        modelAndView.addObject("activeType", productType);
        modelAndView.addObject("listOfItems", catalogService.getItemsByProductType(productType));

        return modelAndView;
    }

    @GetMapping("/settings/add")
    public ModelAndView catalogAddItem() {

        ModelAndView modelAndView = new ModelAndView("admin/catalog/add");
        defineFormData(modelAndView);
        return modelAndView;
    }

    @GetMapping("/settings/{id}")
    public ModelAndView catalogUpdateItem(@PathVariable("id") Long id) {

        ModelAndView modelAndView = new ModelAndView("admin/catalog/show");
        defineFormData(modelAndView);

        Catalog catalog = catalogService.getItemById(id);
        modelAndView.addObject("catalog", catalog);

        return modelAndView;
    }

    @PostMapping("/settings/{id}/delete")
    @ResponseBody
    public void catalogDeleteItem(@PathVariable("id") Long id) {

        catalogService.deleteItem(id);
    }

    @GetMapping("/settings/{id}/updateGlass")
    public ModelAndView updateGlass(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {

        ModelAndView modelAndView = new ModelAndView("redirect:/calculator/");

        Catalog catalog = catalogService.getItemById(id);

        redirectAttributes.addFlashAttribute("catalog", catalog);
        redirectAttributes.addFlashAttribute("isTemplate", true);

        return modelAndView;
    }

    @PostMapping("/settings/save")
    public ModelAndView catalogSaveItem(@ModelAttribute("order") @Validated Catalog catalog,
                                        BindingResult result,
                                        @RequestParam("tableGlass") String tableGlass) {

        ModelAndView modelAndView = new ModelAndView();

        Set<Glass> glassList = jsonEditor.parseGlassList(tableGlass);
        catalog.setGlassList(glassList);

        if (result.hasErrors()) {
            modelAndView.addObject("order", catalog);
            modelAndView.addObject("isForTemplate", true);
            modelAndView.setViewName("general/calculator");
            return modelAndView;
        }

        modelAndView.setViewName("redirect:/catalog/settings/" + catalog.getId());
        catalogService.updateItem(catalog);

        return modelAndView;
    }

    @PostMapping("/settings/upload")
    @ResponseBody
    public JsonResponse catalogUploadFile(@RequestParam MultipartFile file, @RequestParam ProductType productType)
            throws ImageStorageException {

        JsonResponse jsonResponse = new JsonResponse();

        Catalog catalog = catalogService.createItem(file, productType);
        jsonResponse.setResult(catalog.getId());
        jsonResponse.setStatus("SUCCESS");

        return jsonResponse;
    }

    @GetMapping("/displayImage")
    public void catalogAddItem(@RequestParam Long id, HttpServletResponse response)
            throws IOException {

        Catalog catalog = catalogService.getItemById(id);
        response.setContentType("image/jpg,image/png");
        response.getOutputStream().write(catalog.getImage().getData());

        response.getOutputStream().close();
    }

    public void defineFormData(ModelAndView modelAndView) {

        modelAndView.addObject("productTypes", ProductType.values());
    }
}
