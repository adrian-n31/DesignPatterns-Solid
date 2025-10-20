package rotten.pizza.model;

import rotten.pizza.service.PizzaConfig;

public class Margherita implements Pizza {
    @Override public String getName() {return "Margherita";}
    @Override public double getBasePrice() {return PizzaConfig.pret_Margherita;}
    @Override public String toString() {
        return getName();
    }
}
