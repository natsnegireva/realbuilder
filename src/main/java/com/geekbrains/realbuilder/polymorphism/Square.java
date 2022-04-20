package com.geekbrains.realbuilder.polymorphism;

public class Square extends Figura {
    int a;

    public Square(int a) {
        this.a = a;
    }

    public double Area (){
        return a * a;
    }

    public void PrintArea(){
        System.out.println("Площадь квадрата: "+ Area());
    }

}
