package com.github.brianmmcclain.k8sshopbackend;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "count")
    private int count;

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() { 
        return this.price;
    }

    public int getCount() {
        return this.count;
    }
}