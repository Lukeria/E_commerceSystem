package com.e_commerceSystem.entities;

import com.e_commerceSystem.entities.items.Item;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "price_list")
public class PriceList {

    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @Column(name = "price_USD")
    private float priceUSD;

    @Column(name = "price_BYN")
    private float priceBYN;

    public PriceList() {
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

    public float getPriceUSD() {
        return priceUSD;
    }

    public void setPriceUSD(float priceUSD) {
        this.priceUSD = priceUSD;
    }

    public float getPriceBYN() {
        return priceBYN;
    }

    public void setPriceBYN(float priceBYN) {
        this.priceBYN = priceBYN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceList priceList = (PriceList) o;
        return id == priceList.id && Float.compare(priceList.priceUSD, priceUSD) == 0 && Float.compare(priceList.priceBYN, priceBYN) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, priceUSD, priceBYN);
    }
}
