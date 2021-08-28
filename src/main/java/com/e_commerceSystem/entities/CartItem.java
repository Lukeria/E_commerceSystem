package com.e_commerceSystem.entities;

import com.e_commerceSystem.entities.embedded_keys.CartItemKey;
import com.e_commerceSystem.entities.components.Component;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "cart_item")
public class CartItem {

    @EmbeddedId
    private CartItemKey id;

    private int amount;
    private float price;

    @Column(name = "product_type")
    private String productType;

    @ManyToOne
    @MapsId("cartId")
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @MapsId("componentId")
    @JoinColumn(name = "component_id")
    private Component component;

    public CartItem() {
    }

    public CartItemKey getId() {
        return id;
    }

    public void setId(CartItemKey id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component item) {
        this.component = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return amount == cartItem.amount && Float.compare(cartItem.price, price) == 0 && id.equals(cartItem.id) && productType.equals(cartItem.productType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, price, productType);
    }
}
