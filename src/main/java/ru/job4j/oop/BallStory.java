package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Ball ball = new Ball("Колоб");
        Wolf wolf = new Wolf();
        Fox fox = new Fox();
        Hare hare = new Hare();

        System.out.println("Колобка пытается съесть волк");
        wolf.tryEat(ball);
        System.out.println("Колобка пытается съесть заяц");
        hare.tryEat(ball);
        System.out.println(ball.name + "а пытается съесть лиса..");
        fox.tryEat(ball);

        System.out.println("Ну тогда волк  пытается съесть зайца");
        wolf.tryEatAll(hare);
    }
}
