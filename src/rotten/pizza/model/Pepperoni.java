package rotten.pizza.model;

import rotten.pizza.service.PizzaConfig;

public class Pepperoni implements Pizza {
    @Override public String getName() {return "Pepperoni";}
    @Override public double getBasePrice() {return PizzaConfig.pret_Pepperoni;}
    @Override public String toString() {
        return getName();
    }
}

