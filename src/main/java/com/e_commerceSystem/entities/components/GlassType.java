package com.e_commerceSystem.entities.components;

import com.e_commerceSystem.entities.Glass;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@NamedQuery(name = "get_glass_type_all", query = "from GlassType")

@Entity
@DiscriminatorValue("glass_type")
public class GlassType extends Component{

    private Integer thickness;

    @OneToMany(mappedBy = "glassType")
    private Set<Glass> glass = new HashSet<>();

    public GlassType() {
    }

    public Integer getThickness() {
        return thickness;
    }

    public void setThickness(Integer thickness) {
        this.thickness = thickness;
    }

    public Set<Glass> getGlass() {
        return glass;
    }

    public void setGlass(Set<Glass> glass) {
        this.glass = glass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GlassType glassType = (GlassType) o;
        return thickness == glassType.thickness;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), thickness);
    }
}
