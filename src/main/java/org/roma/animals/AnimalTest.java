package org.roma.animals;

public class AnimalTest {
    public static void main(String[] args) {
        Animal[] animals = new Animal[4];
        animals[0] = new Cat("Tom");
        animals[1] = new Cat("Bob");
        animals[2] = new Dog("Ana");
        animals[3] = new Dog("Sam");
        Animal.printAnimalCount();
        Cat.printCatCount();
        Dog.printDogCount();

        Animal cat = new Cat("Timothy");
        cat.run(134);

        Animal dog = new Dog("Bernie");
        dog.run(257);

        Cat[] hungryCats = new Cat[3];
        hungryCats[0] = new Cat("Tim");
        hungryCats[1] = new Cat("James");
        hungryCats[2] = new Cat("Fill");

        Feeder feeder = new Feeder(100);
        feeder.feed(hungryCats[0], 30);
        feeder.feed(hungryCats[1], 30);
        feeder.feed(hungryCats[2], 50);

        for (Cat c : hungryCats) {
            System.out.println("Кот " + c.name + " сыт: " + c.getFullness());
        }
    }
}
