package rotten.pizza.app;

import rotten.pizza.model.Hawaiian;
import rotten.pizza.model.Margherita;
import rotten.pizza.model.Pepperoni;
import rotten.pizza.model.Pizza;
import rotten.pizza.service.MenuPizzaFactory;
import rotten.pizza.service.PizzaConfig;
import rotten.pizza.service.PizzaFactory;
import rotten.pizza.service.PriceCalculator;

import java.util.Scanner;

public class PizzaApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== MENU ===");
        System.out.println("1. " + PizzaConfig.nume_Margherita);
        System.out.println("2. " + PizzaConfig.nume_Pepperoni);
        System.out.println("3. " + PizzaConfig.nume_Hawaiian);
        System.out.println("4. " + PizzaConfig.nume_QuattroFormaggi);

        System.out.print("Choose number: ");
        String choice = sc.nextLine();

//        Pizza selectedPizza;
//        if (choice.equals("1")) selectedPizza = new Margherita();
//        else if (choice.equals("2")) selectedPizza = new Pepperoni();
//        else selectedPizza = new Hawaiian();

        String pizzaName = switch (choice) {
            case "1" -> PizzaConfig.nume_Margherita;
            case "2" -> PizzaConfig.nume_Pepperoni;
            case "3" -> PizzaConfig.nume_Hawaiian;
            case "4" -> PizzaConfig.nume_QuattroFormaggi;
            default -> throw new IllegalArgumentException("Invalid choice");
        };

        PizzaFactory factory = new MenuPizzaFactory();
        Pizza selectedPizza = factory.create(pizzaName);

        System.out.print("Quantity: ");
        int qty = Integer.parseInt(sc.nextLine());

        PriceCalculator calculator = new PriceCalculator();
        double total = qty * calculator.calculateTotalPrice(selectedPizza);

        String receipt = selectedPizza.getName() + " x" + qty + " = " + total + " " + PizzaConfig.currencySymbol;
        System.out.println(receipt);
        System.out.println("=== BON APETIT ===");
    }
}