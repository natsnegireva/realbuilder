package com.geekbrains.realbuilder.polymorphism;


public class Triangle extends Figura {
    int a;
    int b;
    int c;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double Area (){
    double p = (double)(a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public void PrintArea(){
        System.out.println("Площадь треугольника: "+ Area());
    }
}
