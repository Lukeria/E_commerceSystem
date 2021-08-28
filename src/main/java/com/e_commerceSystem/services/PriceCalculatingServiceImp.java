package com.e_commerceSystem.services;

import com.e_commerceSystem.dao_interface.ItemDao;
import com.e_commerceSystem.entities.items.Glass;
import com.e_commerceSystem.entities.items.Item;
import com.e_commerceSystem.repositories.ItemDaoImp;
import com.e_commerceSystem.service_interface.PriceCalculatingService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PriceCalculatingServiceImp implements PriceCalculatingService {

    @Autowired
    private ItemDao itemDao;

    public float calculatePrice(Map<String,String> allParams){

        ObjectMapper objectMapper = new ObjectMapper();
//        List<LinkedHashMap<String, Object>> table = null;
//        try {
//            table = objectMapper.readValue(allParams.get("tableJSON"), List.class);
//        } catch (IOException e){
//            e.printStackTrace();
//        }

        List<Glass> table = null;
        try {
            table = objectMapper.readValue(allParams.get("tableJSON"), new TypeReference<List<Glass>>(){});
        } catch (IOException e){
            e.printStackTrace();
        }

//        List<Glass> glassList = table.stream()
//                .map(glass->{
//                    return itemDao.getGlassByTypeThickness(glass.getGlassType(), glass.getThickness());
//                })
//                .collect(Collectors.toList());


        return 5;
    }

}
