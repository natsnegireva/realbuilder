package com.geekbrains.realbuilder.codeArr;

public class decisionApp {
    // Ошибки:
    // 1. не допускается многократное наследование, только многократная имплементация (класс Lorry)
    // 2. у метода Car не определен тип параметра Engine или внутренний класс, интерфейс, enum Engine, еще и public
    // 3. логично, что метод start() класса Car должен быть вынесен в функциональный интерфейс по типу Stopable,
    //    или метод stop() добавлен в класс Car, тогда не нужен иннтерфейс Stopable
    //    Lorry и LightWeightCar унаследовали от Car, только его абстрактный метод open()

    // я бы сделала 3 класса Car и Lorry, LightWeightCar с наследованием от Car,
    // Car чертеж, Lorry, LightWeightCar - наследники

}
