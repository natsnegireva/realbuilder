package com.geekbrains.realbuilder.polymorphism;


public class Circle extends Figura {
    int a;

    public Circle(int a) {
        this.a = a;
    }

    public double Area (){
        return Math.PI * a * a;
    }
    public void PrintArea(){
        System.out.println("Площадь круга: "+ Area());
    }
}
