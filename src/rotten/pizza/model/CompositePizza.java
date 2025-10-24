package rotten.pizza.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CompositePizza implements Pizza {
    private final List<Pizza> components = new ArrayList<>();

    public void add(Pizza p) {
        components.add(p);
    }

    @Override
    public String getName() {
        return components.stream()
                .map(Pizza::getName)
                .collect(Collectors.joining(" + "));
    }

    @Override
    public double getBasePrice() {
        return components.stream()
                .mapToDouble(Pizza::getBasePrice)
                .sum();
    }

    @Override
    public String toString() {
        return getName();
    }
}