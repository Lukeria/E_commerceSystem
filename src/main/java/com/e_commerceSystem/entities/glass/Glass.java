package com.e_commerceSystem.entities.glass;

import com.e_commerceSystem.entities.Order;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Glass implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer width;
    private Integer height;
    private Integer amount;

    @ManyToOne
    @JoinColumn(name = "glass_type_id")
    @JsonProperty("type")
    private GlassType glassType;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "Glass_Processing",
            joinColumns = { @JoinColumn(name = "glass_id") },
            inverseJoinColumns = { @JoinColumn(name = "processing_id") }
    )
    private Set<Processing> processingList = new HashSet<>();

    @Transient
    private List<Processing> processingArrayList = new ArrayList<>();

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
//        glassType.addToGlass(this);
    }

    public Set<Processing> getProcessingList() {
        return processingList;
    }

    public void setProcessingList(Set<Processing> processingList) {

       this.processingList = processingList;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public List<Processing> getProcessingListAsList() {
        return new ArrayList<>(processingList);
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
//        order.addToGlassList(this);
    }

    public List<Processing> getProcessingArrayList() {
        return processingArrayList;
    }

    public void setProcessingArrayList(List<Processing> processingArrayList) {
        this.processingArrayList = processingArrayList;
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
