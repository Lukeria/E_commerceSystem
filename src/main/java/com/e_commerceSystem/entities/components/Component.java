package com.e_commerceSystem.entities.components;

import com.e_commerceSystem.entities.OrderItem;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
    private Set<OrderItem> accessories = new HashSet<>();

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

    public Set<OrderItem> getAccessories() {
        return accessories;
    }

    public void setAccessories(Set<OrderItem> accessories) {

        this.accessories.retainAll(accessories);
        this.accessories.addAll(accessories);
        for (OrderItem orderItem : accessories) {
            orderItem.setComponent(this);
        }
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
