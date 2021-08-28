package com.e_commerceSystem.entities.items;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;
import java.util.Objects;


@NamedQuery(name = "get_glass_all", query ="from Glass")

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Glass extends Item {

    @JsonProperty("type")
    @Column(name = "glass_type")
    private String glassType;
    private Float size;
    private Integer thickness;

    @JsonProperty("processing")
    @Column(name = "glass_processing")
    private Boolean glassProcessing;
    @Transient
    private int width;
    @Transient
    private int height;

    public Glass() {
    }

    public String getGlassType() {
        return glassType;
    }

    public void setGlassType(String glassType) {
        this.glassType = glassType;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public int getThickness() {
        return thickness;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    public boolean isGlassProcessing() {
        return glassProcessing;
    }

    public void setGlassProcessing(boolean glassProcessing) {
        this.glassProcessing = glassProcessing;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Glass glass = (Glass) o;
        return Float.compare(glass.size, size) == 0 && thickness == glass.thickness && glassProcessing == glass.glassProcessing && glassType.equals(glass.glassType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(glassType, size, thickness, glassProcessing);
    }
}
