package com.e_commerceSystem.entities;

import com.e_commerceSystem.entities.glass.Glass;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Catalog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_type")
    private String productType;

    @OneToOne
    @JoinColumn(name = "image_id")
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.DELETE})
    private Image image;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "catalog")
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.DELETE})
    private Set<Glass> glassList;

    public Catalog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
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
        this.glassList = glassList;
    }
}
