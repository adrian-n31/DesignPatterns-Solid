package rotten.pizza.service;

import rotten.pizza.model.Pizza;

public class PriceCalculator {
    public double calculateTotalPrice(Pizza pizza) {
        double pret = pizza.getBasePrice();
        double tax = pret * PizzaConfig.taxRate;
        return pret + tax;
    }
}
