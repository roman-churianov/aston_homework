package org.roma.figures;

/*
Реализовать методы расчета периметра и площади в качестве дефолтных в интерфейсе не получилось,
потому что в методах необходимо использовать переменные - длины сторон и радиус,
а в интерфейсах можно задавать только статические константы (public static final),
что не подходит для расчета формул для конкретных фигур.

Чтобы не повторять в каждом классе поля fillColor и borderColor они вынесены в суперкласс Figure,
от которого наследуются классы конкретных фигур.
* */

public class TestFigures {

    public static void testPrintInfo() {
        FigureInterface[] figures = new FigureInterface[3];
        figures[0] = new Circle(3, "White", "Blue");
        figures[1] = new Rectangle(2, 4, "Yellow", "Orange");
        figures[2] = new Triangle(3, 4, 5, "Violet", "Brown");

        for (FigureInterface fi : figures) {
            fi.printInfo();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        testPrintInfo();
    }
}
