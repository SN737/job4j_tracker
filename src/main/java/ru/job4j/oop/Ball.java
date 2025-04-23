package ru.job4j.oop;

public class Ball {

    public String name;

    public Ball(String name) {
        this.name = name;
    }

    public void tryRun(boolean condition) {
        if (condition) {
            System.out.println("Колобок съеден");
        } else {
            System.out.println("Колобок смог убежать");
        }

    }
}
