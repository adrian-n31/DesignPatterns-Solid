package rotten.pizza.service;

import rotten.pizza.model.Pizza;

public interface PizzaFactory {
    Pizza create(String name);
}
