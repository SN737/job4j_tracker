package ru.job4j.oop;

public class Wolf {

    public void tryEat(Ball ball) {
        ball.tryRun(false);
    }

    public void tryEatAll(Hare copyHare) {
        copyHare.tryRun(true);
    }
}


