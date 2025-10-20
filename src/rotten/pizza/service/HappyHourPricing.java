package rotten.pizza.service;

public class HappyHourPricing implements PricingStrategy {
    private static final double discount = 0.20;

    @Override
    public double apply(double net) {
        return net - (net * discount);
    }
}
