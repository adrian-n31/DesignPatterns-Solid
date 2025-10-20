import java.util.Scanner;

public class PizzaApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== MENU ===");
        System.out.println("1. " + PizzaConfig.nume_Margherita);
        System.out.println("2. " + PizzaConfig.nume_Pepperoni);
        System.out.println("3. " + PizzaConfig.nume_Hawaiian);

        System.out.print("Choose number: ");
        String choice = sc.nextLine();
        String pizza = "";
        if (choice.equals("1")) pizza = PizzaConfig.nume_Margherita;
        else if (choice.equals("2")) pizza = PizzaConfig.nume_Pepperoni;
        else pizza = PizzaConfig.nume_Hawaiian;

        System.out.print("Quantity: ");
        int qty = Integer.parseInt(sc.nextLine());

        double price = 0;
        switch (pizza) {
            case PizzaConfig.nume_Margherita -> price = PizzaConfig.pret_Margherita;
            case PizzaConfig.nume_Pepperoni -> price = PizzaConfig.pret_Pepperoni;
            case PizzaConfig.nume_Hawaiian -> price = PizzaConfig.pret_Hawaiian;
        }

        double total = qty * (price + price * PizzaConfig.taxRate);
        String receipt = pizza + " x" + qty + " = " + total + " " + PizzaConfig.currencySymbol;
        System.out.println(receipt);
    }
}