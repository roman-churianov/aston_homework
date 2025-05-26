package org.roma.animals;

/* Миска с едой */

public class Feeder {

    private int foodAmount;

    public Feeder(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    public void setFoodAmount(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    public void increaseFoodAmount(int additionalFoodAmount) {
        this.foodAmount += additionalFoodAmount;
    }

    public void feedCat(Cat cat, int amountToFeed) {
        if (amountToFeed <= foodAmount) {
            foodAmount = foodAmount - amountToFeed;
            cat.setFullnes(true);
        } else {
            cat.setFullnes(false);
        }
    }
}
