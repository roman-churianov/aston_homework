package org.roma;

public class Triangle {
    public static double triangleArea(double a, double b, double c) {
        double semiPer = (a + b + c) / 2;
        return Math.sqrt(semiPer * (semiPer - a) * (semiPer - b) * (semiPer - c));
    }
}
