package com.e_commerceSystem.services;


import com.e_commerceSystem.entities.glass.Glass;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class JsonEditor{

    public Set<Glass> parseGlassList(String text){

        ObjectMapper mapper = new ObjectMapper();

        List<Glass> value = null;

        try {
            value = mapper.readValue(text, new TypeReference<List<Glass>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Glass glass: value) {
            glass.setAmount(0);
            glass.setProcessingList(new HashSet<>(glass.getProcessingArrayList()));
        }

        return new HashSet<Glass>(value);
    }
}
