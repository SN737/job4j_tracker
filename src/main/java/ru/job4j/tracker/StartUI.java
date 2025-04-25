package ru.job4j.tracker;

public class StartUI {
    public static void printDate() {
        Item item = new Item();
        System.out.println(item.getCreated());
    }

    public static void main(String[] args) {
        printDate();
    }
}
