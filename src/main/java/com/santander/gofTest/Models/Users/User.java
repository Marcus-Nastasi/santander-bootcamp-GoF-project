package com.santander.gofTest.Models.Users;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private BigInteger id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    @ManyToOne
    private BigInteger address_id;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigInteger getAddress_id() {
        return address_id;
    }

    public void setAddress_id(BigInteger address_id) {
        this.address_id = address_id;
    }
}



