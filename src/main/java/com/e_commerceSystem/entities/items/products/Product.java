package com.e_commerceSystem.entities.items.products;

import com.e_commerceSystem.entities.Order;
import com.e_commerceSystem.entities.items.Item;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "product_id")
public abstract class Product extends Item {

    @Column(nullable = false)
    private String productType;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && productType.equals(product.productType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productType);
    }
}
