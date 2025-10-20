package rotten.pizza.service;

import rotten.pizza.model.Pizza;

public class PriceCalculator {
    private PricingStrategy strategy;

    public PriceCalculator() {
        this.strategy = new RegularPricing(); // default
    }

    public PriceCalculator(PricingStrategy pricingStrategy) {
        this.strategy = pricingStrategy;
    }

    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.strategy = pricingStrategy;
    }


    public double calculateTotalPrice(Pizza pizza) {
        double pret = pizza.getBasePrice();
        double pretDiscount = strategy.apply(pret);
        double tax = pretDiscount * PizzaConfig.taxRate;
        return pretDiscount + tax;
    }

    public PricingStrategy getPricingStrategy() {
        return strategy;
    }
}
