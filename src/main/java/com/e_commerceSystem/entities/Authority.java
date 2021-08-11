package com.e_commerceSystem.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "authorities")
public class Authority {

    @Id
    @Column(name = "authority")
    private String authority;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "authority")
    private Set<User> users = new HashSet<>();

    public Authority() {
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
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
        Authority authority1 = (Authority) o;
        return authority.equals(authority1.authority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authority);
    }

    @Override
    public String toString() {
        return "Authority{" +
                "authority='" + authority + '\'' +
                '}';
    }
}
