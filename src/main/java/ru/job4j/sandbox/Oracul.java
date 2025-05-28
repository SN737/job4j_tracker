package ru.job4j.sandbox;

import java.util.Random;
import java.util.Scanner;

public class Oracul {
    public static void main(String[] args) {
        System.out.println("Готов свичнуться? Введи кол во проходов");
        Scanner rawInput = new Scanner(System.in);
        int input = rawInput.nextInt();
        for (int i = 0; i < input; i++) {
            String result = base();
            if (result.isEmpty()) {
                i--;
            } else {
                System.out.println(result);
            }
        }
    }

    public static String base() {
        String answer = "";
        int random = new Random().nextInt(10);
        switch (random) {
            case 0 -> answer = "Java";
            case 1 -> answer = "Devops";
            case 3 -> answer = "Devops + курс";
            case 5 -> answer = "забей, ищи Одмином работу";
            case 7 -> answer = "есть что то получше!";
            default -> base();
        }
        return answer;
    }

}
