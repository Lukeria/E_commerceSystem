package com.e_commerceSystem.services;

import com.e_commerceSystem.additional.UTF8Control;
import com.e_commerceSystem.entities.Message;
import com.e_commerceSystem.services.interfaces.MessageService;
import org.springframework.stereotype.Service;

import java.util.Formatter;
import java.util.Locale;
import java.util.ResourceBundle;

@Service
public class MessageServiceImp implements MessageService {

    @Override
    public String getMessageText(Message message, String lang) {

        ResourceBundle resourceBundle = ResourceBundle.getBundle("messages/messages",
                Locale.forLanguageTag(lang), new UTF8Control());

        String text = resourceBundle.getString("message.callRequest.text");
        String email = resourceBundle.getString("message.callRequest.email");
        String topic = resourceBundle.getString("message.callRequest.topic");
        String messageText = resourceBundle.getString("message.callRequest.message");

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
