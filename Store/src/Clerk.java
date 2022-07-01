import java.util.Random;
import java.util.Scanner;

public class Clerk {
    public void processOrder(Customer c) {
        if (c.isCartEmpty()) return;
        double withTax = c.getCartTotal() * 1.0875;
        System.out.printf("Your total with tax is %.2f. Are there any problems?\n", withTax);

        if (c.isProblem()) {
            callManager();
        }
        System.out.println("Thank you!");
        c.clearCart();
    }

    public void callManager() {
        Random r = new Random();
        Scanner k = new Scanner(System.in);
        Manager manager = new Manager();

        manager.question();
        k.nextLine();

        if (r.nextDouble() <= 0.5) manager.yell();
        else manager.resolve();
    }
}
