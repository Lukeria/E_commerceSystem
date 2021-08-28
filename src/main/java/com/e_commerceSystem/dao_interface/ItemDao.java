package com.e_commerceSystem.dao_interface;

import com.e_commerceSystem.entities.items.Glass;

import java.util.List;

public interface ItemDao {

    Glass getGlassByTypeThickness(String type, int thickness);
    List<Glass> getGlassAll();
}
