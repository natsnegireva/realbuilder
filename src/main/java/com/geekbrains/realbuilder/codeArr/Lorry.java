package com.geekbrains.realbuilder.codeArr;

public class Lorry extends Car, Moveable, Stopable {
    @Override
    void open() {}

    @Override
    public void move() {
        System.out.println("Car is moving");
    }

    @Override
    public void stop() {
        System.out.println("Car is stop");
    }
}
