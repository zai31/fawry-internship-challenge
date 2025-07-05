package code.classesAndInterfaces.model.ConcreteProducts;

import code.classesAndInterfaces.model.AbstractProduct.Product;
import code.classesAndInterfaces.Interfaces.Expirable;

import java.time.LocalDate;

public class Biscuits extends Product implements Expirable {
    private LocalDate expiryDate;
    public Biscuits(String name, double price, int quantity, LocalDate expiryDate) {

        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean isExpired() {
        return expiryDate != null && LocalDate.now().isAfter(expiryDate);
    }
}
