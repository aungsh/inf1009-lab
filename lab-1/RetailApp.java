import java.util.ArrayList;
import java.util.Scanner;

class Item {
    private String sku;
    private String name;
    private double price;
    private int quantity;
    
    public Item(String sku, String name, double price, int quantity) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return sku + " | " + name + " | $" + price + " | Qty: " + quantity;
    }

    public double getPrice() {
    return price;
    }

    public int getQuantity() {
        return quantity;
    }
}

class Inventory {
    private Scanner scanner;
    private String name;
    private double budget;
    private ArrayList<Item> items = new ArrayList<>();

    public Inventory(String name, double budget, ArrayList<Item> items, Scanner scanner) {
        this.name = name;
        this.budget = budget;
        this.items = items;
        this.scanner = scanner;
    }

    public void addItem() {
        System.out.println("--- Add Item ---");

        System.out.print("Enter SKU: ");
        String sku = scanner.nextLine();

        System.out.print("Enter item name: ");
        String name = scanner.nextLine();

        double price = 0;
        int quantity = 0;

        while(price <= 0) {
            System.out.print("Enter price (> 0): ");
            price = Double.parseDouble(scanner.nextLine());

            if (price <= 0) {
                System.out.println("Price must be more than 0.");
            }
        }

        while(quantity <= 0) {
            System.out.print("Enter quantity (> 0): ");
            quantity = Integer.parseInt(scanner.nextLine());

            if (quantity <= 0) {
                System.out.println("Quantity must be more than 0.");
            }
        }

        items.add(new Item(sku, name, price, quantity));
        System.out.println("Item added successfully.");
    }

    public void viewInventory() {
        if (items.isEmpty()) {
            System.out.println("No items in inventory.");
        } else {
            System.out.println("--- Inventory ---");
            double total = 0;

            for (Item item : items) {
                System.out.println(item);
                total += item.getPrice() * item.getQuantity();
            }

            System.out.println("Total Inventory Value: $" + total);
        }
    }
}

public class RetailApp {
    private Inventory inventory;
    private Scanner scanner = new Scanner(System.in);

    public RetailApp() {
        setup();
        menu();
    }

    public void setup() {
        System.out.print("Store Name: ");
        String storeName = scanner.nextLine();

        System.out.print("Budget: ");
        double budget = Double.parseDouble(scanner.nextLine());

        inventory = new Inventory(storeName, budget, new ArrayList<>(), scanner);

        System.out.println("Welcome, " + storeName + "!");
        System.out.println("Current Budget: $" + budget);
    }

    public void menu() {
        while(true) {
            System.out.println("\n====== Retail Management System ======");
            System.out.println("[1] Add Item");
            System.out.println("[2] View Inventory");
            System.out.println("[3] Exit");

            System.out.print("Select Option: ");
            String option = scanner.nextLine();

            switch(option) {
                case "3":
                    System.out.println("Exiting...");
                    return;

                case "1":
                    inventory.addItem();
                    break;

                case "2":
                    inventory.viewInventory();
                    break;

                default:
                    System.out.println("Please select a valid option.");
            }
        }
    }

    public static void main(String[] args) {
        new RetailApp();
    }
}