package org.roma;
import java.util.Arrays;

public class Lesson22 {

    // 1
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    // 2
    public static void checkSumSign() {
        int a = -23;
        int b = 57;
        int c = a + b;
        if (c >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    // 3
    public static void printColor() {
        int value = 1124;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    // 4
    public static void compareNumbers() {
        int a = 10, b = 35;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    // 5
    public static boolean checkSum(int a, int b) {
        if (10 <= a + b && a + b <= 20) {
            return true;
        }
        return false;
    }

    // 6
    public static void checkPositive(int a) {
        if (a >= 0) {
            System.out.println("Positive");
        } else {
            System.out.println("Negative");
        }
    }

    // 7
    public static boolean checkNegative(int a) {
        return a < 0;
    }

    // 8
    public static void printString(String str, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(str);
        }
    }

    // 9
    public static boolean checkLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return true;
        }
        return false;
    }

    // 10
    public static void invertArray() {
        int[] arr = {1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    // 11
    public static void fillArray() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr));
    }

    // 12
    public static void modifyArray() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    // 13
    public static void fillDiagonals() {
        int n = 5;
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i][i] = 1;
            matrix[i][n - i - 1] = 1;
        }
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    // 14
    public static int[] createArray(int len, int initialValue) {
        int[] arr = new int[len];
        Arrays.fill(arr, initialValue);
        return arr;
    }

    public static void main(String[] args) {
        System.out.println("1:");
        printThreeWords();

        System.out.println("2:");
        checkSumSign();

        System.out.println("3:");
        printColor();

        System.out.println("4:");
        compareNumbers();

        System.out.println("5:");
        System.out.println(checkSum(10, 12));

        System.out.println("6:");
        checkPositive(95);

        System.out.println("7:");
        System.out.println(checkNegative(-23));

        System.out.println("8:");
        printString("New line!", 3);

        System.out.println("9:");
        System.out.println(checkLeapYear(2024));
        System.out.println(checkLeapYear(400));
        System.out.println(checkLeapYear(2300));

        System.out.println("10:");
        invertArray();

        System.out.println("11:");
        fillArray();

        System.out.println("12:");
        modifyArray();

        System.out.println("13:");
        fillDiagonals();

        System.out.println("14:");
        System.out.println(Arrays.toString(createArray(5, 71)));
    }
}