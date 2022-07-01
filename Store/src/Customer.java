import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Customer {
    private ArrayList<Clothing> cart;

    public Customer() {
        cart = new ArrayList<>();
    }

    public void addToCart(Clothing c) {
        cart.add(c);
    }

    public void removeFromCart(int n) {
        cart.remove(n);
    }

    public void sortCart() {
        Collections.sort(cart);
    }

    public void showCart() {
        System.out.println(getCartSize() + " total items in the cart.");
        for (Clothing c : cart) {
            String price = String.format("$%.2f", c.getPrice());
            System.out.println(c + ", Price: " + price);
        }
    }

    public double getCartTotal() {
        double total = 0;
        for (Clothing c : cart) {
            total += c.getPrice();
        }
        return total;
    }

    public int getCartSize() {
        return cart.size();
    }

    public boolean isCartEmpty() {
        return cart.isEmpty();
    }

    public boolean isProblem() {
        Scanner k = new Scanner(System.in);
        char input = k.nextLine().toLowerCase().charAt(0);
        return input == 'y';
    }

    public void clearCart() {
        cart = new ArrayList<>();
    }
}
