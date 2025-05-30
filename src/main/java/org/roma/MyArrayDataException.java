package org.roma;

public class MyArrayDataException extends Exception {

    public MyArrayDataException(int i, int j) {
        super("Problem with String to int conversion of element in row " + i + " column " + j);
    }
}
