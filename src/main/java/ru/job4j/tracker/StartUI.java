package ru.job4j.tracker;


import java.time.format.DateTimeFormatter;

public class StartUI {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");

    public static void printDate() {
        Item item = new Item();
        System.out.println(item.getCreated().format(FORMATTER));
    }

    public static void main(String[] args) {
        printDate();
    }
}
