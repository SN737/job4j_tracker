package ru.job4j.polymorphism;

public class Bus implements Transport {
    @Override
    public void move() {
        System.out.println("ДВС с дизельным двигателем");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Пассажиров: " + count);
    }

    @Override
    public int refuel(int refuel) {
        int dieselCost = 60;
        return refuel * dieselCost;
    }
}
