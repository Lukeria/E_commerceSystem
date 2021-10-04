package com.e_commerceSystem.entities;

import com.e_commerceSystem.additional.enums.ProductType;
import com.e_commerceSystem.entities.glass.Glass;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@NamedQuery(name = "get_catalog_by_productType", query = "from Catalog where product_type=:product_type")

@Entity
public class Catalog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "product_type")
    private ProductType productType;

    @OneToOne()
    @JoinColumn(name = "image_id")
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.DELETE})
    private Image image;

    @OneToMany(fetch = FetchType.EAGER,
            mappedBy = "catalog", orphanRemoval = true)
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.DELETE})
    private Set<Glass> glassList = new HashSet<>();

    public Catalog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Set<Glass> getGlassList() {
        return glassList;
    }

    public void setGlassList(Set<Glass> glassList) {

        this.glassList.retainAll(glassList);
        this.glassList.addAll(glassList);
    }

    public boolean isEmpty(){
        return glassList.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Catalog catalog = (Catalog) o;
        return id.equals(catalog.id) && productType == catalog.productType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productType);
    }
}
