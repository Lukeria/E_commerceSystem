package com.e_commerceSystem.entities.embedded_keys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CartItemKey implements Serializable {

    @Column(name = "cart_id")
    private long cartId;

    @Column(name = "item_id")
    private long itemId;

    public CartItemKey() {
    }

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItemKey that = (CartItemKey) o;
        return cartId == that.cartId && itemId == that.itemId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartId, itemId);
    }
}
