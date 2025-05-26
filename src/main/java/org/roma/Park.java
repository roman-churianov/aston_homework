package org.roma;

import java.util.List;
import java.util.ArrayList;

public class Park {

    public class Attraction {
        private String name;
        private String openTime;
        private String closeTime;
        private int price;

        public Attraction(String name, String openTime, String closeTime, int price) {
            this.name = name;
            this.openTime = openTime;
            this.closeTime = closeTime;
            this.price = price;
        }

        public void print() {
            System.out.println("Attraction name: " + name);
            System.out.println("Attraction opens at: " + openTime);
            System.out.println("Attraction closes at: " + closeTime);
            System.out.println("Attraction costs: " + price);
        }
    }

    private List<Attraction> attractions;

    public Park() {
        attractions = new ArrayList<>();
    }

    public void addAttraction(String name, String openTime, String closeTime, int price) {
        Attraction attr = new Attraction(name, openTime, closeTime, price);
        attractions.add(attr);
    }

    public void printAttractions() {
        for (Attraction a : attractions) {
            a.print();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Park amusementPark = new Park();
        amusementPark.addAttraction("Reel", "11:00", "19:00", 100);
        amusementPark.addAttraction("Jump", "12:00", "20:00", 120);
        amusementPark.addAttraction("Movie", "13:00", "21:00", 150);

        amusementPark.printAttractions();
    }
}
