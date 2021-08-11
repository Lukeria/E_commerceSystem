package com.e_commerceSystem.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
@DiscriminatorValue("glass")
public class Glass extends Product{

    @Column(nullable = false)
    private String glassType;
    private String size;
    private int thickness;
    private boolean glassTreatment;

    public Glass() {
    }

    public String getGlassType() {
        return glassType;
    }

    public void setGlassType(String glassType) {
        this.glassType = glassType;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getThickness() {
        return thickness;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    public boolean isGlassTreatment() {
        return glassTreatment;
    }

    public void setGlassTreatment(boolean glassTreatment) {
        this.glassTreatment = glassTreatment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Glass glass = (Glass) o;
        return thickness == glass.thickness && glassTreatment == glass.glassTreatment && glassType.equals(glass.glassType) && Objects.equals(size, glass.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), glassType, size, thickness, glassTreatment);
    }
}
