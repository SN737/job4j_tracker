package ru.job4j.oop;

public class DummyDic {
    public static String engToRus(String eng) {
        String result = "Неизвестное слово " + eng;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(engToRus("fly"));
    }
}
