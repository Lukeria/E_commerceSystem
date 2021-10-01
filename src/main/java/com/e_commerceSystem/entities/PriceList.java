package com.e_commerceSystem.entities;

import com.e_commerceSystem.entities.components.Component;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "price_list")
public class PriceList {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "component_id")
    private Component component;

    @Column(name = "price_USD")
    private Float priceUSD;

    @Column(name = "price_BYN")
    private float priceBYN;

    public PriceList() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component item) {
        this.component = item;
    }

    public Float getPriceUSD() {
        return priceUSD;
    }

    public void setPriceUSD(Float priceUSD) {
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
