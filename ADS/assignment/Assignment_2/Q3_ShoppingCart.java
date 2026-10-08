import java.util.ArrayList;
import java.util.Scanner;

class CartItem {
    String name;
    int price;
    int qty;

    CartItem(String name, int price, int qty) {
        this.name = name;
        this.price = price;
        this.qty = qty;
    }

    int lineTotal() {
        return price * qty;
    }
}

class ShoppingCart {

    private ArrayList<CartItem> items = new ArrayList<>();

    // Search item by name
    private int indexOf(String name) {

        for (int i = 0; i < items.size(); i++) {

            if (items.get(i).name.equalsIgnoreCase(name)) {
                return i;
            }
        }

        return -1;
    }

    // Add item
    public void add(String name, int price, int qty) {

        if (qty <= 0) {
            return;
        }

        int index = indexOf(name);

        if (index != -1) {

            items.get(index).qty += qty;

        } else {

            items.add(new CartItem(name, price, qty));
        }
    }

    // Remove item
    public void remove(String name) {

        int index = indexOf(name);

        if (index != -1) {
            items.remove(index);
        }
    }

    // Update quantity
    public void updateQty(String name, int qty) {

        if (qty < 0) {
            return;
        }

        int index = indexOf(name);

        if (index != -1) {

            if (qty == 0) {
                items.remove(index);
            } else {
                items.get(index).qty = qty;
            }
        }
    }

    // Print bill
    public void printBill() {

        int subtotal = 0;

        for (CartItem item : items) {
            subtotal += item.lineTotal();
        }

        int discount = 0;

        if (subtotal >= 1000) {
            discount = subtotal / 10;
        }

        int afterDiscount = subtotal - discount;

        int delivery = 0;

        if (afterDiscount < 500) {
            delivery = 40;
        }

        int total = afterDiscount + delivery;

        System.out.println("\n----- BILL -----");
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Discount: " + discount);
        System.out.println("Delivery: " + delivery);
        System.out.println("Total: " + total);
    }

    // Find most expensive line
    public CartItem mostExpensiveLine() {

        if (items.isEmpty()) {
            return null;
        }

        CartItem max = items.get(0);

        for (int i = 1; i < items.size(); i++) {

            if (items.get(i).lineTotal() > max.lineTotal()) {
                max = items.get(i);
            }
        }

        return max;
    }

    // Display cart
    public void displayCart() {

        if (items.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        System.out.println("\n----- CART -----");

        for (CartItem item : items) {

            System.out.println(
                "Name: " + item.name +
                ", Price: " + item.price +
                ", Quantity: " + item.qty +
                ", Line Total: " + item.lineTotal()
            );
        }
    }
}

public class Q3_ShoppingCart {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ShoppingCart cart = new ShoppingCart();

        int choice;

        do {

            System.out.println("\n===== ONLINE SHOPPING CART =====");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Update Quantity");
            System.out.println("4. Display Cart");
            System.out.println("5. Print Bill");
            System.out.println("6. Most Expensive Line");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    sc.nextLine();

                    System.out.print("Enter product name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter price: ");
                    int price = sc.nextInt();

                    System.out.print("Enter quantity: ");
                    int qty = sc.nextInt();

                    cart.add(name, price, qty);

                    System.out.println("Product added successfully.");

                    break;

                case 2:

                    sc.nextLine();

                    System.out.print("Enter product name to remove: ");
                    String removeName = sc.nextLine();

                    cart.remove(removeName);

                    System.out.println("Remove operation completed.");

                    break;

                case 3:

                    sc.nextLine();

                    System.out.print("Enter product name: ");
                    String updateName = sc.nextLine();

                    System.out.print("Enter new quantity: ");
                    int newQty = sc.nextInt();

                    cart.updateQty(updateName, newQty);

                    System.out.println("Quantity updated.");

                    break;

                case 4:

                    cart.displayCart();

                    break;

                case 5:

                    cart.printBill();

                    break;

                case 6:

                    CartItem expensive = cart.mostExpensiveLine();

                    if (expensive == null) {

                        System.out.println("Cart is empty.");

                    } else {

                        System.out.println("\nMost Expensive Line:");
                        System.out.println("Name: " + expensive.name);
                        System.out.println("Price: " + expensive.price);
                        System.out.println("Quantity: " + expensive.qty);
                        System.out.println("Line Total: " + expensive.lineTotal());
                    }

                    break;

                case 7:

                    System.out.println("Thank you!");

                    break;

                default:

                    System.out.println("Invalid choice.");
            }

        } while (choice != 7);

        sc.close();
    }
}