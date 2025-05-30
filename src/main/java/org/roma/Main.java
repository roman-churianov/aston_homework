package org.roma;

public class Main {

    /*
    Часть 4 задания к Лекции 5. Генерация и перехват ArrayIndexOutOfBoundsException
    */
    public static void generateAndCatchArrayIndexOutOfBoundsException() {
        int[] array = new int[10];
        try {
            int i = array[10];
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void printStringArray(String[][] array) {
        for (String[] str : array) {
            for (String s : str) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    public static void testDataFourByFourArray() {
        String[][] array = new String[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                array[i][j] = String.valueOf(i + j);
            }
        }
        array[2][3] = "abc";

        printStringArray(array);

        try {
            FourByFourArray.checkFourByFourArray(array);
        } catch (MyArraySizeException | MyArrayDataException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void testSizeFourByFourArray() {
        String[][] array = new String[4][];
        array[0] = new String[4];
        array[1] = new String[6];
        array[2] = new String[2];
        array[3] = new String[3];

        try {
            FourByFourArray.checkFourByFourArray(array);
        } catch (MyArraySizeException | MyArrayDataException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {

        testDataFourByFourArray();
        System.out.println();

        testSizeFourByFourArray();
        System.out.println();

        generateAndCatchArrayIndexOutOfBoundsException();
        System.out.println();
    }
}