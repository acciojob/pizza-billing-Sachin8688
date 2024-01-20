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
        billBuilder.append("Base Price Of The Pizza: ").append(this.price).append(System.lineSeparator());

        if (addedComponents.containsKey("Extra Cheese")) {
            billBuilder.append("Extra Cheese Added: ").append(addedComponents.get("Extra Cheese")).append(System.lineSeparator());
        }
        if (addedComponents.containsKey("Extra Toppings")) {
            billBuilder.append("Extra Toppings Added: ").append(addedComponents.get("Extra Toppings")).append(System.lineSeparator());
        }
        if (addedComponents.containsKey("Paper Bag")) {
            billBuilder.append("Paper Bag Added: ").append(addedComponents.get("Paper Bag")).append(System.lineSeparator());
        }

        billBuilder.append("Total Price: ").append(getPrice()).append(System.lineSeparator());
        this.bill = billBuilder.toString();
        return this.bill;
    }
}
