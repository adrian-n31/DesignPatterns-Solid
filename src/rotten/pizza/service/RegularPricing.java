package rotten.pizza.service;

import rotten.pizza.model.Pizza;

public class RegularPricing implements PricingStrategy {
    @Override
    public double apply(double net) {
        return net;
    }
}
