package com.github.brianmmcclain.k8sshopfrontend;

public class Item {

    private long id;
    private String name;
    private double price;
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

    @Override
    public String toString() {
        return this.getName() + ", $" + this.getPrice() + ", " + this.getCount(); 
    }
}