package org.roma;

public class MyArrayDataException extends Exception {

    /*
    i - номер строки, в которой лежат неверные данные, начиная с 1
    j - номер столбца, в котором лежат неверные данные, начиная с 1
    * */
    public MyArrayDataException(int i, int j) {
        super("Problem with String to int conversion of element in row " + i + " column " + j);
    }
}
