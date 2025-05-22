package org.roma;

public class Product {

    private String name;
    private String productionDate;
    private String producer;
    private String country;
    private int price;
    private boolean bookingState;

    public Product(String name, String productionDate, String producer, String country, int price, boolean bookingState) {
        this.name = name;
        this.productionDate = productionDate;
        this.producer = producer;
        this.country = country;
        this.price = price;
        this.bookingState = bookingState;
    }

    public void print() {
        System.out.println("Product name: " + name);
        System.out.println("Production date: " + productionDate);
        System.out.println("Producer: " + producer);
        System.out.println("Country of origin: " + country);
        System.out.println("Price: " + price);
        System.out.println("Booked by customer: " + bookingState);
    }

    public static void main(String[] args) {
        Product[] productArray = new Product[5];
        productArray[0] = new Product(
                "Table",
                "04.04.1945",
                "Table Factory",
                "Chech Republic",
                12000,
                false
        );
        productArray[1] = new Product(
                "Chair",
                "23.03.1999",
                "Chair Factory",
                "Chair country",
                1000,
                false
        );
        productArray[2] = new Product(
                "Shoes",
                "18.10.1995",
                "Shoe Factory",
                "Montenegro",
                200,
                true
        );
        productArray[3] = new Product(
                "Sneakers",
                "12.05.2021",
                "Shoe Factory",
                "Montenegro",
                250,
                false
        );
        productArray[4] = new Product(
                "Pencil",
                "24.09.1967",
                "Pencil Factory",
                "Canada",
                12,
                true
        );
    }
}
