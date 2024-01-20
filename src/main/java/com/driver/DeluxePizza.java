package com.driver;

public class DeluxePizza extends Pizza {
    public DeluxePizza(Boolean isVeg) {
        super(isVeg);
        // Deluxe pizza comes with extra cheese and toppings by default
        addExtraCheese();
        addExtraToppings();
    }
}
