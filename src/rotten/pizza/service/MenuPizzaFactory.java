package rotten.pizza.service;

import rotten.pizza.model.Hawaiian;
import rotten.pizza.model.Margherita;
import rotten.pizza.model.Pepperoni;
import rotten.pizza.model.QuattroFormaggi;
import rotten.pizza.model.Pizza;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class MenuPizzaFactory implements PizzaFactory {
    private final Map<String, Supplier<Pizza>> menu = new HashMap<>();

    public void registerPizza(String name, Supplier<Pizza> supplier) {
        menu.put(name.toLowerCase(), supplier);
    }

    public MenuPizzaFactory() {
        registerPizza(PizzaConfig.nume_Margherita, Margherita::new);
        registerPizza(PizzaConfig.nume_Pepperoni, Pepperoni::new);
        registerPizza(PizzaConfig.nume_Hawaiian, Hawaiian::new);
        registerPizza(PizzaConfig.nume_QuattroFormaggi, QuattroFormaggi::new);
    }

    public Pizza create(String name) {
        Supplier<Pizza> supplier = menu.get(name.toLowerCase());
        if (supplier == null)
            throw new IllegalArgumentException("Pizza not found: " + name);
        return supplier.get();
    }
}
