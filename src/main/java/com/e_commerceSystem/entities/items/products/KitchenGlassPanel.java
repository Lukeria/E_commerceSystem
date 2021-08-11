package com.e_commerceSystem.entities.items.products;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "Kitchen_glass_panels")
@PrimaryKeyJoinColumn(name = "kitchen_glass_panel_id")
public class KitchenGlassPanel extends Product{

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            joinColumns = { @JoinColumn(name = "kitchen_glass_panel_id") },
            inverseJoinColumns = { @JoinColumn(name = "glass_id") }
    )
    private Set<Glass> glass = new HashSet<>();

    public KitchenGlassPanel() {
    }

    public Set<Glass> getGlass() {
        return glass;
    }

    public void setGlass(Set<Glass> glass) {
        this.glass = glass;
    }
}
