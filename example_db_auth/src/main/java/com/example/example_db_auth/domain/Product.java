package com.example.example_db_auth.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String dateOfSupply;
    private boolean status;

    public Product() {
    }

    public Product(String name, String dateOfSupply) {
        this.name = name;
        this.dateOfSupply = dateOfSupply;
        this.status=true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfSupply() {
        return dateOfSupply;
    }

    public void setDateOfSupply(String dateOfSupply) {
        this.dateOfSupply = dateOfSupply;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
