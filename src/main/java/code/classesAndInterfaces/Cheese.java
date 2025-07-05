package code.classesAndInterfaces;

import java.time.LocalDate;

public class Cheese extends Product implements Expirable, shippable{

    private LocalDate expiryDate;
private double weight;
    public Cheese(String name, double price, int quantity, LocalDate expiryDate, double weight) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
        this.weight = weight;
    }
@Override
    public boolean isExpired() {
        return expiryDate != null && LocalDate.now().isAfter(expiryDate);
    }
@Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String getProductName() {
        return getName();
    }

}
