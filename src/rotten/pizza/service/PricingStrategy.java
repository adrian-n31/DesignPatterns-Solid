package rotten.pizza.service;

public interface PricingStrategy {
    double apply(double net);
}
