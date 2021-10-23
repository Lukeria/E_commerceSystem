package com.e_commerceSystem.services.interfaces;

import com.e_commerceSystem.entities.Message;

public interface MessageService {

    String getMessageText(Message message, String lang);
}
