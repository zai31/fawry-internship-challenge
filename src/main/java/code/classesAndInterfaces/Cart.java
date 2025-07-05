package code.classesAndInterfaces;

import java.util.List;

public class Cart {

    private List<CartItem> CartItems;

    public Cart(List<CartItem> CartItems) {
        this.CartItems = CartItems;
    }
    public void addItem(Product product, int quantity) {
        CartItem cartItem = new CartItem(product, quantity);
        CartItems.add(cartItem);
    }
    public void removeItem(Product product) {
        for (CartItem cartItem : CartItems) {
            if (cartItem.getProduct().equals(product)) {
                CartItems.remove(cartItem);
                break;
            }
        }
    }
    boolean isEmpty() {
        return CartItems.isEmpty();
    }
    void clearCart() {
        CartItems.clear();
    }

   List<CartItem> getItems() {
       return CartItems;
   }

    }

