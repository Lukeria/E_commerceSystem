package com.e_commerceSystem.entities.items;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Facet extends Item{

    private int width;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facet")
    private Set<Mirror> mirrors = new HashSet<>();

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Set<Mirror> getMirrors() {
        return mirrors;
    }

    public void setMirrors(Set<Mirror> mirrors) {
        this.mirrors = mirrors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Facet facet = (Facet) o;
        return width == facet.width;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width);
    }
}
