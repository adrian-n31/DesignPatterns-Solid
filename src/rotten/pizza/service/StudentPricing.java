package rotten.pizza.service;

import rotten.pizza.model.Pizza;

public class StudentPricing implements PricingStrategy {
    private static final double discount = 0.10;

    @Override
    public double apply(double net) {
        return net - (net * discount);
    }
}
