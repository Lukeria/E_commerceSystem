package com.e_commerceSystem.entities.items.products;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "Shower_cabins")
@PrimaryKeyJoinColumn(name = "shower_cabin_id")
public class ShowerCabin extends Product{

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            joinColumns = { @JoinColumn(name = "shower_cabin_id") },
            inverseJoinColumns = { @JoinColumn(name = "glass_id") }
    )
    private Set<Glass> glass = new HashSet<>();
    private String doorMechanism;

    public ShowerCabin() {
    }

    public Set<Glass> getGlass() {
        return glass;
    }

    public void setGlass(Set<Glass> glass) {
        this.glass = glass;
    }

    public String getDoorMechanism() {
        return doorMechanism;
    }

    public void setDoorMechanism(String doorMechanism) {
        this.doorMechanism = doorMechanism;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ShowerCabin that = (ShowerCabin) o;
        return Objects.equals(doorMechanism, that.doorMechanism);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), doorMechanism);
    }
}
