package com.e_commerceSystem.services;

import com.e_commerceSystem.entities.Message;
import com.e_commerceSystem.services.interfaces.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImp implements MessageService {

    private final LocaleMessageHandler localeMessageHandler;

    @Autowired
    public MessageServiceImp(LocaleMessageHandler localeMessageHandler) {

        this.localeMessageHandler = localeMessageHandler;
    }

    @Override
    public String getMessageText(Message message, String lang) {

        String text = localeMessageHandler.getMessage("message.callRequest.text");
        String email = localeMessageHandler.getMessage("message.callRequest.email");
        String topic = localeMessageHandler.getMessage("message.callRequest.topic");
        String messageText = localeMessageHandler.getMessage("message.callRequest.message");

        StringBuilder result = new StringBuilder();

        result.append(String.format(text, message.getCustomer() != null ? message.getCustomer().getName() : "",
                message.getCustomer() != null ? message.getCustomer().getPhone() : ""))
                .append("\n")
                .append(String.format(email, message.getCustomer() != null ? message.getCustomer().getEmail() : ""))
                .append("\n")
                .append(String.format(topic, message.getTopic() != null ? message.getTopic() : ""))
                .append("\n")
                .append(String.format(messageText, message.getMessage() != null ? message.getMessage() : ""));

        return result.toString();
    }
}
