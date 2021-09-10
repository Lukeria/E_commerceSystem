package com.e_commerceSystem.entities.glass;

import com.e_commerceSystem.additional.ComponentViews;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@DiscriminatorValue("processing")
public class Processing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @TableGenerator(table = "sequence", name = "IdGenerator")
    @JsonView(ComponentViews.Normal.class)
    private Long id;

    @JsonView(ComponentViews.Normal.class)
    private String type;

    @JsonView(ComponentViews.Normal.class)
    private String name;

    @JsonIgnore
    private String symbol;

    @JsonView(ComponentViews.PriceList.class)
    private Float price;

    @JsonView(ComponentViews.PriceList.class)
    private Float priceUSD;

    @Transient
    private Integer quantity;

    @ManyToMany(mappedBy = "processingList")
    @JsonIgnore
    private Set<Glass> glass = new HashSet<>();

    public Processing() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Set<Glass> getGlass() {
        return glass;
    }

    public void setGlass(Set<Glass> glass) {
        this.glass = glass;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getPriceUSD() {
        return priceUSD;
    }

    public void setPriceUSD(Float priceUSD) {
        this.priceUSD = priceUSD;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Processing that = (Processing) o;
        return id.equals(that.id) && type.equals(that.type) && name.equals(that.name) && Objects.equals(symbol, that.symbol) && price == that.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, symbol, price, type);
    }
}
