package com.e_commerceSystem.entities.items.products;

import javax.persistence.*;
import java.util.*;

@Entity(name = "mirror_panels")
public class MirrorPanel extends Product{

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            joinColumns = { @JoinColumn(name = "mirror_panel_id") },
            inverseJoinColumns = { @JoinColumn(name = "mirror_id") }
    )
    private Set<Mirror> mirrors = new HashSet<>();

    public MirrorPanel() {
    }

    public Set<Mirror> getMirrors() {
        return mirrors;
    }

    public void setMirrors(Set<Mirror> mirrors) {
        this.mirrors = mirrors;
    }
}
