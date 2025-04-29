package ru.job4j.cast;

public class Plane implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " Moves very fast");
    }

    @Override
    public void environment() {
        System.out.println(getClass().getSimpleName() + " flying in the air");
    }
}
