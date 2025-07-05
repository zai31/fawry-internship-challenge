package code.classesAndInterfaces;

import java.util.HashMap;
import java.util.List;

public class ShippingService {
    HashMap<String, Integer> productCount = new HashMap<>();
        HashMap<String, Double> productWeight = new HashMap<>();

    public void shipProducts(List<shippable> shippables) {
        double totalWeight=0;
        for (shippable item : shippables) {
            String name = item.getProductName();
            double weight = item.getWeight();
            productCount.put(name, productCount.getOrDefault(name, 0) + 1);
            productWeight.put(name, productWeight.getOrDefault(name, 0.0) + item.getWeight());
            totalWeight += weight;
        }

        System.out.println("** Shipment notice **");
        for (String name : productCount.keySet()) {
            int count = productCount.get(name);
            double weight = productWeight.get(name);

                 System.out.println(count + "x " + name + " " + weight+"kg");
        }
        System.out.println("Shipment total weight: " + totalWeight+"kg");
    }
}
