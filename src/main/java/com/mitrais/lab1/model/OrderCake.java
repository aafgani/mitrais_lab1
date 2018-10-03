package com.mitrais.lab1.model;

public class OrderCake extends Cake {
    private double weight;

    public OrderCake(String name, double rate) {
        super(name, rate);
    }

    public OrderCake(String name, double rate, Double weight) {
        super(name, rate);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public double calcPrice() {
        return weight*rate;
    }
}
