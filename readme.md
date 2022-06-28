# Store

- Create a store. The store sells shirts, pants, and suits (each their own class).

- Have a way to keep track of inventory and orders.

- When a customer makes an order, the clerk should process it.

- If there is a problem, the manager should be called.

- You must have a way to sort items (Comparable) either in the customers cart or in inventory.

- Make sure to explain which Java Design Pattern you chose and implemented.

## Buyable Interface

```java
public interface Buyable {
    double getPrice();
}
```

- The Buyable interface is implemented for all clothing items that are purchased to have the `getPrice` method. When an object is Buyable, then it means it has a price. Therefore, this interface was implemented for all clothing items.

## Clothing Class

```java
public abstract class Clothing implements Buyable, Comparable<Clothing> {
    protected double price;

    @Override
    public double getPrice() {
        return price;
    }

    public int compareTo(Clothing c) {
        return (Double.compare(this.price, c.price));
    }

    public abstract String toString();
}
```

- The abstract Clothing class provides a `price` field, and the definition for the `getPrice` method by returning the `price` field value.

- The Clothing class additionally implements the Comparable interface, which forces it to provide a definition for the `compareTo` method.
  
  - The Comparable interface was implemented with type `Clothing` since the `compareTo` function takes in another Clothing type object as an argument.
  
  - The `compareTo` method defines how Clothing objects are to be compared. In this case, Clothing objects are compared by price. This is used for sorting Clothing type data structures, and is used later on.

- The Clothing class declares an abstract `toString` method, which forces its subclasses to provide the definition for it. This is used for displaying the objects, as it overrides the default `toString` method that returns the object's memory address.

## Shirt, Pants, and Suit Class

```java
public class Shirt extends Clothing {
    public Shirt(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Shirt";
    }
}
```

```java
public class Pants extends Clothing {
    public Pants(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Pants";
    }
}
```

```java
public class Suit extends Clothing {
    public Suit(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Suit";
    }
}
```

- The Shirt, Suit, and Pants class all contain a regular constructor that sets the price of the object.

- Each class additionally has a custom `toString` method that returns the name of the respective clothing article.

## Builder Design Pattern

```java
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
```

- The builder design pattern is used to create an object in a series of steps.

- Inside of the `newItem` method, there are multiple options presented that affect the price value that is passed into the constructor when creating the object. As seen in the code block above, choices for size and quality both impact the price of the object.

- Additionally, there is a selection for the clothing type. The switch statement is used at the end in order to return different object types based off of what the user selects.

- This design pattern works great for this specific project, since there are multiple choices that need to be taken into account before creating the object, which therefore requires a series of choices for the user to make.

- The `remove` method is used to delete an object that was previously created. It uses a `Customer` type argument, and removes the clothing item that is in the customer's cart at the specified index. The Customer class can be seen below.

## Customer Class

```java
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
```

- The Customer class is used as a form of inventory management. It manages all of the created clothing items from the builder design pattern by using an ArrayList.

- Using polymorphism, a `Clothing` type ArrayList is used as a field value. This allows for Shirt, Suit, and Pants type objects to all be passed into the same ArrayList. This is done through the `addToCart` method, which adds the clothing item passed in as an argument to the ArrayList.

- Additionally, the `removeFromCart` method is declared, which removes the item at a specified index from the ArrayList. This method is called by the `removeFromCart` method in the inventory class, due to the fact that the inventory class cannot modifying the `cart` ArrayList directly.

- There are methods for convenience that are present in the customer class.
  
  - `displayCart` shows all of the items currently in the cart by printing the clothing type and price for each item.
  
  - `sortCart` sorts the items in the cart from cheapest to most expensive by using the `Collections.sort` method. This uses the `compareTo` method that was defined in the clothing class.
  
  - `getCartSize` returns the size of the ArrayList, which represents the number of clothing items in the cart.
  
  - `getCartTotal` returns the sum of the price for all of the clothing items currently in the cart.
  
  - `isCartEmpty` returns true when there are zero items in the cart, and false otherwise.
  
  - `clearCart` removes all of the items that are currently in the cart.

- Finally, the `isProblem` method is defined for when the customer wants to purchase the items stored in their cart. It defines how the clerk will react when processing the customer's order.

## Clerk and Manager Class

```java
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
```

```java
public class Manager {
    public void question() {
        System.out.println("Manager: What seems to be the problem?");
    }
    public void yell() {
        System.out.println("Manager: Get out of my store!");
        System.exit(0);
    }
    public void resolve() {
        System.out.println("Manager: I'm sorry, we will compensate you.");
    }
}
```

- The Clerk class is used to process the customer's order.

- This is done by accepting a Customer type argument into the `processOrder` function. The function does nothing if the customer's cart is empty. Otherwise, it will get the total of all of the clothing items in the customer's cart, and then return the total with tax added on.

- The clerk then calls the `isProblem` method that was defined in the Customer class. If there is no problem, the transaction finishes, and the customer's cart is cleared. Otherwise, the clerk calls the manager using the `callManager` method.

- The `callManager` method creates a new Manager object, and calls its `question` method. The customer is then prompted for input to express their problem.

- The manager's response to the customer is decided at random. If a value less than or equal to 0.5 is generated, the manager response negatively, and kicks the customer out by ending the program.

- If a value greater than 0.5 is generated, the manager response positively, apologizing to the customer, and compensating them. The transaction is then completed, and the customer's cart is cleared.

## Main Class

```java
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
```

The previous Classes all provided the methods for one iteration for creating a clothing item. The main function therefore implemented the previous methods and classes created, and uses a while loop. This allows for the customer to add as many items to their cart as they want, as well as having the choice to interact with the other cart methods.

- The customer is allowed to add items, check the cart, remove items from the cart,  display the items in the cart, sort the items in the cart, and clear the cart as many times as they like. This is done using a switch statement, where certain numbers are mapped to different method calls.

- The customer could change their order however they like using the above methods before processing their order. Once the process order option is selected, (if the manager does not get angry), the customer's cart is cleared, and they can go back to ordering more items.