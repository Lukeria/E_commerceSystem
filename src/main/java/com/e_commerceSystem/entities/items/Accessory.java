package com.e_commerceSystem.entities.items;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name = "accessories")
@PrimaryKeyJoinColumn(name = "accessory_id")
public class Accessory extends Item{

    private String name;
}
