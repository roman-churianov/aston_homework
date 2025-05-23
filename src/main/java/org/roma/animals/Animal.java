package org.roma.animals;

public class Animal {

    protected String name;

    private static int animalCount = 0;

    public Animal() {
        ++animalCount;
    }

    public void run(int obstacleLength) {
        System.out.println("Животное пробежало " + obstacleLength + " м.");
    }

    public void swim(int obstacleLength) {
        System.out.println("Животное проплыло " + obstacleLength + " м.");
    }

    public static final void printAnimalCount() {
        System.out.println("Общее число созданных животных: " + animalCount);
    }
}
