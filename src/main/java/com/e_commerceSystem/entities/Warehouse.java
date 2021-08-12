package com.e_commerceSystem.entities;

import com.e_commerceSystem.entities.items.Item;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Warehouse {

    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    private int amount;

    public Warehouse() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Warehouse warehouse = (Warehouse) o;
        return id == warehouse.id && amount == warehouse.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount);
    }
}
