package com.geekbrains.realbuilder.collections;

public class AppCollections {
    public static void main(String[] args) {
        MyArrayList Students= new MyArrayList();
        Students.add(0 ,"Nika");
        Students.add(1 ,"Max");
        Students.add(2 ,"Lana");
        Students.add(3 ,"Stas");
        Students.add(4 ,"Alex");
        Students.remove(4);
        for( int i=0; i<Students.getSize(); i++){
            System.out.println(Students.get(i));
        }
        System.out.println(Students.find("Nika"));

        MyLinkedList Students1 = new MyLinkedList();
        Students1.add("Nika", 0);
        Students1.add("Max", 1);
        Students1.add("Lana", 2);
        Students1.add("Stas", 3);
        Students1.add("Alex",4);
        Students1.remove(3);
        Students1.reverse();
        for (int i = 0; i < Students1.getSize(); i++) {
            System.out.println(Students1.get(i));
        }
        System.out.println(Students.find("Stas"));
    }
}
