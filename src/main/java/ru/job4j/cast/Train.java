package ru.job4j.cast;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " Moves moderate fast");
    }

    @Override
    public void environment() {
        System.out.println(getClass().getSimpleName() + " moves on the rails");
    }
}
