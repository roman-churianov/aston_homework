package org.roma;

public class FourByFourArray {

    public static long checkFourByFourArray(String[][] strArray) throws MyArraySizeException, MyArrayDataException {
        if (strArray.length != 4) {
            throw new MyArraySizeException(strArray.length);
        }
        for (String[] str : strArray) {
            if (str.length != 4) {
                throw new MyArraySizeException(str.length);
            }
        }

        long sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    sum += Integer.parseInt(strArray[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i+1, j+1);
                }
            }
        }

        return sum;
    }
}
