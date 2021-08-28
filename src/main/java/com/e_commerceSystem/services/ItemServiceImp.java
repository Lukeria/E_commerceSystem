package com.e_commerceSystem.services;

import com.e_commerceSystem.dao_interface.ItemDao;
import com.e_commerceSystem.entities.items.Glass;
import com.e_commerceSystem.service_interface.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemServiceImp implements ItemService {

    @Autowired
    ItemDao itemDao;

    @Override
    public List<Glass> getGlassList() {
        return itemDao.getGlassAll();
    }
}
