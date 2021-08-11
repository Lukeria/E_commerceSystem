package com.e_commerceSystem.entities.items.products;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@PrimaryKeyJoinColumn(name = "glass_id")
public class Glass extends Product {

    @Column(nullable = false)
    private String glassType;
    private String size;
    private int thickness;
    private boolean glassTreatment;

    @ManyToMany(mappedBy = "glass")
    private Set<ShowerCabin> showerCabins = new HashSet<>();

    @ManyToMany(mappedBy = "glass")
    private Set<GlassWall> glassWalls = new HashSet<>();

    @ManyToMany(mappedBy = "glass")
    private Set<KitchenGlassPanel> kitchenGlassPanels = new HashSet<>();

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

    public Set<ShowerCabin> getShowerCabins() {
        return showerCabins;
    }

    public void setShowerCabins(Set<ShowerCabin> showerCabins) {
        this.showerCabins = showerCabins;
    }

    public Set<GlassWall> getGlassWalls() {
        return glassWalls;
    }

    public void setGlassWalls(Set<GlassWall> glassWalls) {
        this.glassWalls = glassWalls;
    }

    public Set<KitchenGlassPanel> getKitchenGlassPanels() {
        return kitchenGlassPanels;
    }

    public void setKitchenGlassPanels(Set<KitchenGlassPanel> kitchenGlassPanels) {
        this.kitchenGlassPanels = kitchenGlassPanels;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Glass glass = (Glass) o;
        return thickness == glass.thickness && glassTreatment == glass.glassTreatment && glassType.equals(glass.glassType) && Objects.equals(size, glass.size);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), glassType, size, thickness, glassTreatment);
    }
}
