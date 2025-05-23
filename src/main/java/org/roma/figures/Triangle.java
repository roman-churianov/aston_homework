package org.roma.figures;

public class Triangle extends Figure implements FigureInterface {

    private double a, b, c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Triangle(double a, double b, double c,
                    String fillColor, String borderColor)
    {
        super(fillColor, borderColor);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double area() {
        double semiPer = (a + b + c) / 2;
        return Math.sqrt(semiPer * (semiPer - a) * (semiPer - b) * (semiPer - c));
    }

    @Override
    public double perimeter() {
        return a + b + c;
    }

    @Override
    public void printInfo() {
        System.out.println("Triangle");
        System.out.println("Perimeter: " + perimeter());
        System.out.println("Area: " + area());
        System.out.println("Fill color: " + getFillColor());
        System.out.println("Border color: " + getBorderColor());
    }
}
