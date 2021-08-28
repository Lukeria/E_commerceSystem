package com.e_commerceSystem.entities.components;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("accessory")
public class Accessory extends Component {

    public Accessory() {
    }
}
