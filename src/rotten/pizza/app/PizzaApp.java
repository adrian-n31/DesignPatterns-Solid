package rotten.pizza.app;

import rotten.pizza.model.Hawaiian;
import rotten.pizza.model.Margherita;
import rotten.pizza.model.Pepperoni;
import rotten.pizza.model.Pizza;
import rotten.pizza.service.*;

import java.util.Scanner;

public class PizzaApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== MENU ===");
        System.out.println("1. " + PizzaConfig.nume_Margherita + " " + PizzaConfig.pret_Margherita + PizzaConfig.currencySymbol);
        System.out.println("2. " + PizzaConfig.nume_Pepperoni + " " + PizzaConfig.pret_Pepperoni + PizzaConfig.currencySymbol);
        System.out.println("3. " + PizzaConfig.nume_Hawaiian + " " + PizzaConfig.pret_Hawaiian + PizzaConfig.currencySymbol);
        System.out.println("4. " + PizzaConfig.nume_QuattroFormaggi + " " + PizzaConfig.pret_QuattroFormaggi + PizzaConfig.currencySymbol);

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

        System.out.println("\nChoose your deal:");
        System.out.println("1) Regular (no discount)");
        System.out.println("2) Student (~10%)");
        System.out.println("3) Happy Hour (~20%)");

        System.out.print("Choose deal: ");
        String dealChoice = sc.nextLine();

        PriceCalculator calculator = new PriceCalculator();
        switch (dealChoice) {
            case "2":
                calculator.setPricingStrategy(new StudentPricing());
                break;
            case "3":
                calculator.setPricingStrategy(new HappyHourPricing());
                break;
            default:
                calculator.setPricingStrategy(new RegularPricing());
        }

        System.out.print("Quantity: ");
        int qty = Integer.parseInt(sc.nextLine());

//        PriceCalculator calculator = new PriceCalculator();
//        double total = qty * calculator.calculateTotalPrice(selectedPizza);

        double unitPrice = calculator.calculateTotalPrice(selectedPizza);
        double total = qty * unitPrice;

        String receipt = selectedPizza.getName() + " x" + qty + " = " +  String.format("%.2f", total) + " " + PizzaConfig.currencySymbol;
        System.out.println(receipt);
        System.out.println("=== BON APETIT ===");
    }
}