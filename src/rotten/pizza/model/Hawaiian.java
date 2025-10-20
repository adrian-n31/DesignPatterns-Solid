package rotten.pizza.model;

import rotten.pizza.service.PizzaConfig;

public class Hawaiian implements Pizza {
    @Override public String getName() {return "Hawaiian";}
    @Override public double getBasePrice() {return PizzaConfig.pret_Hawaiian;}
    @Override public String toString() {
        return getName();
    }
}
