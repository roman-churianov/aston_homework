package org.roma.figures;

public class Rectangle extends Figure implements FigureInterface {

    private double a, b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Rectangle(double a, double b, String fillColor, String borderColor) {
        super(fillColor, borderColor);
        this.a = a;
        this.b = b;
    }

    @Override
    public double area() {
        return a * b;
    }

    @Override
    public double perimeter() {
        return 2 * a + 2 * b;
    }

    @Override
    public void printInfo() {
        System.out.println("Rectangle");
        System.out.println("Perimeter: " + perimeter());
        System.out.println("Area: " + area());
        System.out.println("Fill color: " + getFillColor());
        System.out.println("Border color: " + getBorderColor());
    }
}
