package com.mitrais.lab1.model;

public class ReadyMadeCake extends Cake {
    private double quantity;

    public ReadyMadeCake(String name, double rate, Double quantity) {
        super(name, rate);
        this.quantity = quantity;
    }

    public ReadyMadeCake(String name, double rate) {
        super(name, rate);
    }

    public double getQuantity() {
        return quantity;
    }

    public double calcPrice() {
        return quantity*rate;
    }
}
