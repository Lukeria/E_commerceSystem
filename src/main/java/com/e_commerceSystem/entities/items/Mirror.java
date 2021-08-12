package com.e_commerceSystem.entities.items;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Mirror extends Item {

    private float size;
    private boolean lightning;

    @ManyToOne
    @JoinColumn(name = "facet_id")
    private Facet facet;

    @Column(name = "mirror_processing")
    private boolean processing;

    public Mirror() {
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public boolean isProcessing() {
        return processing;
    }

    public void setProcessing(boolean processing) {
        this.processing = processing;
    }

    public boolean isLightning() {
        return lightning;
    }

    public void setLightning(boolean lightning) {
        this.lightning = lightning;
    }

    public Facet getFacet() {
        return facet;
    }

    public void setFacet(Facet facet) {
        this.facet = facet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mirror mirror = (Mirror) o;
        return Float.compare(mirror.size, size) == 0 && lightning == mirror.lightning && processing == mirror.processing && Objects.equals(facet, mirror.facet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, lightning, facet, processing);
    }
}
