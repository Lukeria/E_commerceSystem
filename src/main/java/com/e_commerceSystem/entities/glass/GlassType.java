package com.e_commerceSystem.entities.glass;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "glass_type")
public class GlassType{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "IdGenerator")
    @TableGenerator(table = "sequence", name = "IdGenerator")
    protected Long id;
    protected String name;
    private Integer thickness;

    @JsonIgnore
    private Float price;

    @OneToMany(mappedBy = "glassType")
    @JsonIgnore
    private Set<Glass> glass = new HashSet<>();

    public GlassType() {
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

    public Integer getThickness() {
        return thickness;
    }

    public void setThickness(Integer thickness) {
        this.thickness = thickness;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GlassType glassType = (GlassType) o;
        return id.equals(glassType.id) && name.equals(glassType.name) && thickness.equals(glassType.thickness) && price == glassType.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, thickness, price);
    }
}
