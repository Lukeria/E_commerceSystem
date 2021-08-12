package com.e_commerceSystem.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Cart {

    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private int amount;
    private float price;
    private float cost;
    private boolean active;

    @Column(name = "expiration_date", nullable = false)
    private LocalDateTime expirationDate;

    public Cart() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return id == cart.id && amount == cart.amount && Float.compare(cart.price, price) == 0 && Float.compare(cart.cost, cost) == 0 && active == cart.active && expirationDate.equals(cart.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, price, cost, active, expirationDate);
    }
}
