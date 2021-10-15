package com.e_commerceSystem.controllers;

import com.e_commerceSystem.additional.JsonResponse;
import com.e_commerceSystem.entities.Message;
import com.e_commerceSystem.services.interfaces.MessageService;
import com.e_commerceSystem.validation.MessageValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
public class TelegramController {

    private final MessageService messageService;
    private final MessageValidator messageValidator;

    @Autowired
    public TelegramController(MessageService messageService,
                              MessageValidator messageValidator) {
        this.messageService = messageService;
        this.messageValidator = messageValidator;
    }

    @InitBinder(value = "message")
    protected void initBinder(WebDataBinder binder) {

        binder.setValidator(messageValidator);
    }

    @PostMapping("/send")
    @ResponseBody
    public JsonResponse sendMessage(@RequestBody @Validated Message message,
                                              BindingResult result) {

        JsonResponse response = new JsonResponse();

        if (result.hasErrors()) {
            response.setResult(result.getAllErrors());
            response.setStatus(HttpStatus.BAD_REQUEST);
            return response;
        }

        RestTemplate restTemplate = new RestTemplate();

        String text = messageService.getMessageText(message, LocaleContextHolder.getLocale().toLanguageTag());
        String fooResourceUrl
                = "https://api.telegram.org/bot1968871201:AAEHY-8GIZwcIf4604SRyW29yhUmcCJamTk/sendMessage";

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(fooResourceUrl)
                .queryParam("chat_id", "-1001572595899")
                .queryParam("text", text);


        response.setStatus(restTemplate.getForEntity(builder.build().toUriString(), String.class).getStatusCode());

        return response;

    }
}
