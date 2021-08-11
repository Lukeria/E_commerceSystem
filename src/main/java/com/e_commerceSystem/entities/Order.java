package com.e_commerceSystem.entities;

import com.e_commerceSystem.entities.items.products.Product;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private Set<Product> products = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
