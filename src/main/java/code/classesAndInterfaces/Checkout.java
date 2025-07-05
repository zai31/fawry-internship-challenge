package code.classesAndInterfaces;

import java.util.ArrayList;
import java.util.List;

public class Checkout {

    private static double SHIPPING_COST_PER_KG  ;
    public void setShippingCostPerKg(double shippingCostPerKg) {
        SHIPPING_COST_PER_KG = shippingCostPerKg;
    }

    public double getShippingCostPerKg() {
                return SHIPPING_COST_PER_KG;
    }

    public void checkout(User user, Cart cart) {
        if (cart.isEmpty()) throw new IllegalArgumentException("Cart is empty");

        double subtotal = 0;
        double totalWeight = 0;
        List<shippable> shippables = new ArrayList<>();

        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            int qty = item.getQuantity();


            if (product instanceof Expirable && ((Expirable) product).isExpired()) {
                throw new IllegalArgumentException("Product " + product.getName() + " is expired.");
            }

            if (qty > product.getQuantity()) {
                throw new IllegalArgumentException("Not enough stock for " + product.getName());
            }

            product.reduceQuantity(qty);
            subtotal += product.getPrice() * qty;

            if (product instanceof shippable) {
                for (int i = 0; i < qty; i++) {
                    shippables.add((shippable) product);
                    totalWeight += ((shippable) product).getWeight();
                }
            }
        }

        double shippingFee = shippables.isEmpty() ? 0 : SHIPPING_COST_PER_KG*totalWeight;
        double total = subtotal + shippingFee;

        if (total > user.getBalance()) {
            throw new IllegalArgumentException("Insufficient balance.");
        }

        user.pay(total);

        if (!shippables.isEmpty()) {
            new ShippingService().shipProducts(shippables);
        }

        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.println(item.getQuantity() + "x " + item.getProduct().getName() + " "
                    + item.getProduct().getPrice() * item.getQuantity());

        }
        System.out.println("_______________________________________________");
                System.out.println("Subtotal " + subtotal);
        System.out.println("Shipping " + shippingFee);
        System.out.println("Amount " + total);
        System.out.println("Remaining balance: " + user.getBalance());

        cart.clearCart();
    }
}
