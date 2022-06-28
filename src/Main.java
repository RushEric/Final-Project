import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner k = new Scanner(System.in);
        Customer c = new Customer();
        Clerk cl = new Clerk();
        Inventory b = new Inventory();

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
            int input = Integer.parseInt(k.nextLine());
            switch (input) {
                case 1 -> c.addToCart(b.newItem());
                case 2 -> c.clearCart();
                case 3 -> c.showCart();
                case 4 -> b.remove(c);
                case 5 -> c.sortCart();
                case 6 -> cl.processOrder(c);
                default -> again = false;
            }
        }
    }
}
