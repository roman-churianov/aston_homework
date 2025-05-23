package org.roma.animals;

public class Cat extends Animal {

    private static int runLimit = 200;
    private static int swimLimit = 0;

    private static int catCount = 0;

    private boolean fullness = false; // сытость

    public Cat() {
        ++catCount;
    }

    public Cat(String name) {
        ++catCount;
        this.name = name;
    }

    @Override
    public void run(int obstacleLength) {
        if (0 <= obstacleLength && obstacleLength <= runLimit) {
            System.out.println(this.name + " пробежал " + obstacleLength + " м.");
        } else if (runLimit <= obstacleLength) {
            System.out.println("Кот может пробежать только " + runLimit + " м.");
        } else {
            System.out.println("Введите положительную длину препятствия.");
        }
    }

    @Override
    public void swim(int obstacleLength) {
        System.out.println("Кот не умеет плавать.");
    }

    public static void printCatCount() {
        System.out.println("Общее число созданных котов: " + catCount);
    }

    public void setFullnes(boolean fullness) {
        this.fullness = fullness;
    }

    public boolean getFullness() {
        return fullness;
    }
}
