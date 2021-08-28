package com.e_commerceSystem.entities;

import com.e_commerceSystem.entities.embedded_keys.OrderItemKey;
import com.e_commerceSystem.entities.components.Component;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "order_item")
public class OrderItem {

    @EmbeddedId
    private OrderItemKey id;

    private int amount;
    private float price;

    @Column(name = "product_type")
    private String productType;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @MapsId("componentId")
    @JoinColumn(name = "component_id")
    private Component component;

    public OrderItem() {
    }

    public OrderItemKey getId() {
        return id;
    }

    public void setId(OrderItemKey id) {
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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
        OrderItem cartItem = (OrderItem) o;
        return amount == cartItem.amount && Float.compare(cartItem.price, price) == 0 && id.equals(cartItem.id) && productType.equals(cartItem.productType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, price, productType);
    }
}
