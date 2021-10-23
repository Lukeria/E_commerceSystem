package com.e_commerceSystem.entities.components;

import com.e_commerceSystem.entities.CatalogItem;
import com.e_commerceSystem.entities.OrderItem;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@NamedQuery(name = "get_component_by_component_type", query = "from Component where component_type=:component_type")

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "component_type")
public class Component {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "IdGenerator")
    @TableGenerator(table = "sequence", name = "IdGenerator")
    protected Long id;
    protected String name;
    protected Float price;
    protected Float priceUSD;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "component")
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    @JsonIgnore
    private Set<OrderItem> orderItems = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "component")
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    @JsonIgnore
    private Set<CatalogItem> catalogItems = new HashSet<>();

    public Component() {
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getPriceUSD() {
        return priceUSD;
    }

    public void setPriceUSD(Float priceUSD) {
        this.priceUSD = priceUSD;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Set<CatalogItem> getCatalogItems() {
        return catalogItems;
    }

    public void setCatalogItems(Set<CatalogItem> catalogItems) {
        this.catalogItems = catalogItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Component item = (Component) o;
        return id == item.id && name.equals(item.name) && price == item.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }
}
