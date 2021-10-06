package com.e_commerceSystem.controllers;

import com.e_commerceSystem.additional.CustomUserDetails;
import com.e_commerceSystem.additional.JsonResponse;
import com.e_commerceSystem.additional.enums.OrderStatus;
import com.e_commerceSystem.entities.Order;
import com.e_commerceSystem.entities.User;
import com.e_commerceSystem.entities.glass.Glass;
import com.e_commerceSystem.services.JsonEditor;
import com.e_commerceSystem.services.interfaces.CalculatorService;
import com.e_commerceSystem.services.interfaces.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;
    @Autowired
    private JsonEditor jsonEditor;

    @GetMapping("/")
    public ModelAndView cart(Authentication authentication) {

        User currentUser = ((CustomUserDetails) authentication.getPrincipal()).getUser();

        ModelAndView modelAndView = new ModelAndView("/user/cart");
        modelAndView.addObject("orders",
                cartService.getOrders(currentUser.getCustomer()));

        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView cartAdd(@ModelAttribute("order") Order order,
                                BindingResult result,
                                @RequestParam("tableGlass") String tableGlass,
                                Authentication authentication,
                                RedirectAttributes redirectAttributes) {

        ModelAndView modelAndView = new ModelAndView("redirect:/calculator/");

//        if (order.getProductType().isEmpty()) {
//            result.rejectValue("productType", "message.notEmpty.calculator.productType");
//        }

        Set<Glass> glassList = jsonEditor.parseGlassList(tableGlass);
        order.setGlassList(glassList);

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("order", order);
            return modelAndView;
        } else {
            redirectAttributes.addFlashAttribute("message", "successCreation");
        }

        User currentUser = ((CustomUserDetails) authentication.getPrincipal()).getUser();
        cartService.addOrder(order, currentUser.getCustomer());

        return modelAndView;
    }

    @PostMapping("/{id}/delete")
    @ResponseBody
    public void cartDeleteItem(@PathVariable Long id) {

        cartService.deleteOrder(id);
    }

    @PostMapping("/submit")
    @ResponseBody
    public JsonResponse cartSubmit(@RequestBody List<Long> orderIds) {

        for (Long id : orderIds) {
            cartService.submitCartOrder(id);
        }

        JsonResponse response = new JsonResponse();
        response.setStatus("SUCCESS");
        return response;
    }
}
