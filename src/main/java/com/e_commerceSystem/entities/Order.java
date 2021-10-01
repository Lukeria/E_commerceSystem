package com.e_commerceSystem.entities;

import com.e_commerceSystem.additional.enums.OrderStatus;
import com.e_commerceSystem.entities.glass.Glass;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@NamedQuery(name = "get_order_by_status", query = "from orders where order_status=:order_status")
@NamedQuery(name = "get_order_by_status_and_customer_id",
        query = "from orders where customer_id=:customer_id and order_status=:order_status")

@Entity(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private Customer customer;

    private Float cost;

    @Column(name = "product_type")
    private String productType;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private OrderStatus status;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Transient
    private DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    private LocalDateTime deadline;

    @OneToMany(mappedBy = "order")
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.DELETE})
    private Set<OrderItem> orderItems = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "order")
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.DELETE})
    private Set<Glass> glassList = new HashSet<>();

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public String getCreationDateFormat() {
        return creationDate.format(dateFormat);
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public String getDeadlineFormat() {
        return "";
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Set<Glass> getGlassList() {
        return glassList;
    }

    public void setGlassList(Set<Glass> glassList) {
        this.glassList = glassList;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public boolean isNew() {
        return id == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id.equals(order.id) && Objects.equals(customer, order.customer) && cost.equals(order.cost) && productType.equals(order.productType) && status.equals(order.status) && creationDate.equals(order.creationDate) && Objects.equals(deadline, order.deadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, cost, productType, status, creationDate, deadline);
    }
}
