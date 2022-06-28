import java.util.Scanner;

public class Inventory {
    public Clothing newItem() {
        Scanner k = new Scanner(System.in);
        double price = 0;

        System.out.println("""
                Choose your size:
                1. Small
                2. Medium
                3. Large""");
        int size = k.nextInt();
        switch (size) {
            case 1 -> price += 10;
            case 2 -> price += 20;
            case 3 -> price += 30;
        }

        System.out.println("""
                Choose the quality:
                1. Thrifted
                2. New""");
        int quality = k.nextInt();
        switch (quality) {
            case 1 -> price += 5;
            case 2 -> price += 15;
        }

        System.out.println("""
                Choose the type of clothes you want:
                1. Suit
                2. Shirt
                3. Pants""");
        int type = k.nextInt();
        return switch (type) {
            case 1 -> new Suit(price + 300);
            case 2 -> new Shirt(price + 5);
            case 3 -> new Pants(price + 20);
            default -> null;
        };
    }
    public void remove(Customer c) {
        if (c.isCartEmpty()) return;
        Scanner k = new Scanner(System.in);
        int n;
        do {
            System.out.println("Enter the position of the item you want to remove: ");
            n = Integer.parseInt(k.nextLine());
        } while (n < 0 || n >= c.getCartSize());

        c.removeFromCart(n);
    }
}
