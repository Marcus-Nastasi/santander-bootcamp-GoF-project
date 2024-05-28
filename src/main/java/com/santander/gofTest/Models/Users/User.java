package com.santander.gofTest.Models.Users;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String email;
    private BigInteger address_id;

    public void update(User user) {
        this.setName(user.getName());
        this.setEmail(user.getEmail());
        this.setAddress_id(user.getAddress_id());
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public BigInteger getAddress_id() {
        return address_id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress_id(BigInteger address_id) {
        this.address_id = address_id;
    }
}


