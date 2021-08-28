package com.e_commerceSystem.entities.glass;

import com.e_commerceSystem.entities.Order;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Glass{

    @Id
    protected Long id;
    private Integer width;
    private Integer height;

    @ManyToOne
    @JoinColumn(name = "glass_type_id")
    @JsonProperty("type")
    private GlassType glassType;

    @ManyToMany
    @JoinTable(
            name = "Glass_Processing",
            joinColumns = { @JoinColumn(name = "glass_id") },
            inverseJoinColumns = { @JoinColumn(name = "processing_id") }
    )
    private Set<Processing> processingList = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public Glass() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public GlassType getGlassType() {
        return glassType;
    }

    public void setGlassType(GlassType glassType) {
        this.glassType = glassType;
    }

    public Set<Processing> getProcessingList() {
        return processingList;
    }

    public void setProcessingList(Set<Processing> processingList) {
        this.processingList = processingList;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Glass glass = (Glass) o;
        return Objects.equals(id, glass.id) && Objects.equals(width, glass.width) && Objects.equals(height, glass.height);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, width, height);
    }
}
