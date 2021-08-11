package com.e_commerceSystem.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.Objects;

@Entity(name = "mirrors")
public class Mirror extends Product{

    @OneToOne
    private Glass glass;
    private boolean lightning;
    private String facet;

    public Mirror() {
    }

    public Glass getGlass() {
        return glass;
    }

    public void setGlass(Glass glass) {
        this.glass = glass;
    }

    public boolean isLightning() {
        return lightning;
    }

    public void setLightning(boolean lightning) {
        this.lightning = lightning;
    }

    public String getFacet() {
        return facet;
    }

    public void setFacet(String facet) {
        this.facet = facet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Mirror mirror = (Mirror) o;
        return lightning == mirror.lightning && glass.equals(mirror.glass) && Objects.equals(facet, mirror.facet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), glass, lightning, facet);
    }
}
