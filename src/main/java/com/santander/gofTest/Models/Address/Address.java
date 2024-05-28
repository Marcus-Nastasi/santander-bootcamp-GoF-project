package com.santander.gofTest.Models.Address;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column
    private String street;

    @Column
    private String complement;
    @Column
    private String neighborhood;
    @Column
    private String locale;
    @Column
    private String uf;

    public void update(Address address) {
        this.setStreet(address.getStreet());
        this.setComplement(address.getComplement());
        this.setNeighborhood(address.getNeighborhood());
        this.setLocale(address.getLocale());
        this.setUf(address.getUf());
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}



