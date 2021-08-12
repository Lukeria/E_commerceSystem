package com.e_commerceSystem.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Role {

    @Id
    private long id;
    private String role;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
    private Set<User> users = new HashSet<>();

    public Role() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role1 = (Role) o;
        return id == role1.id && role.equals(role1.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role);
    }
}
