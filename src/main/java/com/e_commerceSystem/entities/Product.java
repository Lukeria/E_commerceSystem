package com.e_commerceSystem.entities;

import javax.persistence.*;
import java.util.Objects;

@MappedSuperclass
public abstract class Product{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @Column(nullable = false)
    private String productType;

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
