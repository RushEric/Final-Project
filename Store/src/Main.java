import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Customer customer = new Customer();
        Clerk clerk = new Clerk();
        Inventory inventory = new Inventory();

        boolean again = true;
        while (again) {
            System.out.println("""
                    ------ Options ------
                    1. Buy new item
                    2. Clear Cart
                    3. Check Cart
                    4. Remove from Cart
                    5. Sort Cart
                    6. Process Order
                    Other Number: Quit
                    ---------------------
                    """);
            int input = Integer.parseInt(keyboard.nextLine());
            switch (input) {
                case 1 -> customer.addToCart(inventory.newItem());
                case 2 -> customer.clearCart();
                case 3 -> customer.showCart();
                case 4 -> inventory.remove(customer);
                case 5 -> customer.sortCart();
                case 6 -> clerk.processOrder(customer);
                default -> again = false;
            }
        }
    }
}
