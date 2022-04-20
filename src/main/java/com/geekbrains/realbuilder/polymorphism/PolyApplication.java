package com.geekbrains.realbuilder.polymorphism;

public class PolyApplication {

    public static void main(String[] args) {

        Square square = new Square(5);
        square.PrintArea();
        Circle circle = new Circle(5);
        circle.PrintArea();
        Triangle triangle = new Triangle(2, 4, 3);
        triangle.PrintArea();

    }
}
