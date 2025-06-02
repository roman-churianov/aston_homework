package org.roma;

public class MyArraySizeException extends Exception {

    public MyArraySizeException() {}

    public MyArraySizeException(int actualSize) {
        super("Actual array size: " + actualSize);
    }

    public MyArraySizeException(String message) {
        super(message);
    }
}
