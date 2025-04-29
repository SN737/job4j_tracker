package ru.job4j.cast;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " Moves slow");
    }

    @Override
    public void environment() {
        System.out.println(getClass().getSimpleName() + " drives on the road");
    }
}
