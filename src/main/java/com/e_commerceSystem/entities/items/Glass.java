package com.e_commerceSystem.entities.items;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Glass extends Item {

    @Column(name = "glass_type")
    private String glassType;
    private float size;
    private int thickness;

    @Column(name = "glass_processing")
    private boolean glassProcessing;

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
