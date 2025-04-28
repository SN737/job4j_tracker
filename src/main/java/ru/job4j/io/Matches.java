package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static int count;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
         count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            if  (count >= 3) {
                System.out.println(player + " введите число от 1 до 3:");
            } else {
                System.out.printf("%s введите число от 1 до %d:", player, count);
            }
            int matches = Integer.parseInt(input.nextLine());

            if (matches > 0 && matches <= 3 && count >= matches) {
                count -= matches;
                printMatchesCount();
                turn = !turn;
            } else if (matches <= 3 && matches > count) {
                System.out.printf("Вам необходимо ввести число не более %s", count);
                printMatchesCount();
            } else {
                System.out.println("Вам необходимо ввести число от 1 до 3");
                printMatchesCount();
            }
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }

    public static void printMatchesCount() {
        System.out.println();
        System.out.println(String.format("Спичек на столе -  %s", count));
    }
}