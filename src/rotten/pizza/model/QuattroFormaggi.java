package rotten.pizza.model;

import rotten.pizza.service.PizzaConfig;

public class QuattroFormaggi implements Pizza {
    @Override public String getName() { return PizzaConfig.nume_QuattroFormaggi; }
    @Override public double getBasePrice() { return PizzaConfig.pret_QuattroFormaggi; }
    @Override public String toString() { return getName(); }
}
