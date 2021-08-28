package com.e_commerceSystem.entities.embedded_keys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CartItemKey implements Serializable {

    @Column(name = "cart_id")
    private Long cartId;

    @Column(name = "component_id")
    private Long componentId;

    public CartItemKey() {
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getComponentId() {
        return componentId;
    }

    public void setComponentId(Long itemId) {
        this.componentId = itemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItemKey that = (CartItemKey) o;
        return cartId == that.cartId && componentId == that.componentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartId, componentId);
    }
}
