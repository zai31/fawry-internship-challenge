package code.classesAndInterfaces;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Products
        Product cheese = new Cheese("Cheese", 100, 5, LocalDate.now().plusDays(2), 0.2);
          Product expiredCheese = new Cheese("Expired Cheese", 100, 5, LocalDate.now().minusDays(1), 0.2);
         Product tv = new TV("TV", 300, 3, 5.0);
  Product scratchCard = new MobileScratchCards("Scratch Card", 50, 10);
        Product biscuits = new Biscuits("Biscuits", 150, 2,  LocalDate.now().plusDays(1));

        // Users
        User UserOfSuffeciantBalance = new User("Ahmed", 100000);
        User UserOfinSuffeciantBalance = new User("Ali", 100);

        // Checkout service
    Checkout checkout = new Checkout();
        checkout.setShippingCostPerKg(10); // as per your call

        // Test 1: Successful Checkout
        System.out.println(" Test Case 1: Successful Checkout ---");
        Cart cart1 = new Cart(new ArrayList<>());
        cart1.addItem(cheese, 2);
        cart1.addItem(tv, 1);
        cart1.addItem(biscuits, 1);
        checkout.checkout(UserOfSuffeciantBalance, cart1);

        // Test 2: Empty cart
        System.out.println("Test Case 2: Empty Cart ---");
      Cart cart2 = new Cart(new ArrayList<>());
        try {
            checkout.checkout(UserOfSuffeciantBalance, cart2);
        } catch (Exception e) {
            System.out.println( e.getMessage());
        }

        //Test 3: Expired product
        System.out.println(" Test Case 3:Expired Product");
        Cart cart3 = new Cart(new ArrayList<>());
        cart3.addItem(expiredCheese, 1);
        try {
            checkout.checkout(UserOfSuffeciantBalance, cart3);
        } catch (Exception e) {
            System.out.println( e.getMessage());
        }

        //Test 4: Quantity exceeds stock
        System.out.println("Test case 4:Quantity Exceeds Stock");
        Cart cart4 = new Cart(new ArrayList<>());
    cart4.addItem(biscuits, 10); // biscuits only has 1 left now
        try {
            checkout.checkout(UserOfSuffeciantBalance, cart4);
        } catch (Exception e) {
            System.out.println( e.getMessage());
        }

        //Test 5:Insufficient balance
        System.out.println(" Test case5:Insufficient Balance");
        Cart cart5 = new Cart(new ArrayList<>());
        cart5.addItem(tv, 1);
        cart5.addItem(cheese, 1);
        try {
            checkout.checkout(UserOfinSuffeciantBalance, cart5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Test 6:Non-shippable,non-expirable
        System.out.println(" Test Case 6: Mobile Scratch Card Only");
        Cart cart6 = new Cart(new ArrayList<>());

 cart6.addItem(scratchCard, 2);
        checkout.checkout(UserOfSuffeciantBalance, cart6);
    }
}
