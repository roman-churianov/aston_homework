package org.roma.animals;

public class Dog extends Animal {

    private static int runLimit = 500;
    private static int swimLimit = 10;

    private static int dogCount = 0;

    public Dog() {
        ++dogCount;
    }

    public Dog(String name) {
        ++dogCount;
        this.name = name;
    }

    @Override
    public void run(int obstacleLength) {
        if (0 <= obstacleLength && obstacleLength <= runLimit) {
            System.out.println(this.name + " пробежал " + obstacleLength + " м.");
        } else if (runLimit <= obstacleLength) {
            System.out.println("Собака может пробежать не более " + runLimit + " м.");
        } else {
            System.out.println("Введите неотрицательную длину препятствия.");
        }
    }

    @Override
    public void swim(int obstacleLength) {
        if (0 <= obstacleLength && obstacleLength <= swimLimit) {
            System.out.println(this.name + " проплыл " + obstacleLength + " м.");
        } else if (swimLimit <= obstacleLength) {
            System.out.println("Собака может пробежать не более " + swimLimit + " м.");
        } else {
            System.out.println("Введите неотрицательную длину препятствия.");
        }
    }

    public static void printDogCount() {
        System.out.println("Общее число созданных собак: " + dogCount);
    }
}
