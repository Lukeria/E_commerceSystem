package com.e_commerceSystem.entities.embedded_keys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderItemKey implements Serializable {

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "component_id")
    private Long componentId;

    public OrderItemKey() {
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getComponentId() {
        return componentId;
    }

    public void setComponentId(Long componentId) {
        this.componentId = componentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemKey that = (OrderItemKey) o;
        return orderId == that.orderId && componentId == that.componentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, componentId);
    }
}
