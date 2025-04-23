package ru.job4j.oop;

public class Hare {
    public void tryEat(Ball ball) {
        ball.tryRun(false);
    }

    public void tryRun(boolean condition) {
        if (condition) {
            System.out.println("Заяц съеден");
        } else {
            System.out.println("Заяц смог убежать");
        }

    }

}
