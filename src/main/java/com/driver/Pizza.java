package com.driver;

import java.util.HashMap;
import java.util.Map;

public class Pizza {

    private int price;
    private Boolean isVeg;
    private String bill;
    private Map<String, Integer> addedComponents;

    public Pizza(Boolean isVeg) {
        this.isVeg = isVeg;
        this.price = isVeg ? 300 : 400;
        this.addedComponents = new HashMap<>();
        this.bill = "";
    }

    public int getPrice() {
        return this.price;
    }

    public void addExtraCheese() {
        if (!addedComponents.containsKey("Extra Cheese")) {
            this.price += 80;
            addedComponents.put("Extra Cheese", 80);
        }
    }

    public void addExtraToppings() {
        if (!addedComponents.containsKey("Extra Toppings")) {
            this.price += (isVeg ? 70 : 120);
            addedComponents.put("Extra Toppings", isVeg ? 70 : 120);
        }
    }

    public void addTakeaway() {
        if (!addedComponents.containsKey("Paper Bag")) {
            this.price += 20;
            addedComponents.put("Paper Bag", 20);
        }
    }

    public String getBill() {
        StringBuilder billBuilder = new StringBuilder();
        billBuilder.append("Base Price Of The Pizza: ").append(this.price).append("\n");

        for (Map.Entry<String, Integer> entry : addedComponents.entrySet()) {
            billBuilder.append(entry.getKey()).append(" Added: ").append(entry.getValue()).append("\n");
        }

        billBuilder.append("Total Price: ").append(getPrice()).append("\n");
        this.bill = billBuilder.toString();
        return this.bill;
    }
}
