package ru.job4j.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        List<String> elements = List.of("one", "two", "three", "four", "five", "six", "seven");
        BiConsumer<Integer, String> biConsumer = (key, value) -> map.put(key, value);
        int i = 1;
        for (String element : elements) {
            biConsumer.accept(i, element);
            i++;
        }

        BiPredicate<Integer, String> biPredicate = (number, string) -> number % 2 == 0 || string.length() == 4;
        for (Integer key : map.keySet()) {
            if (biPredicate.test(key, map.get(key))) {
                System.out.println("key: " + key + " value: " + map.get(key));
            }
        }

        Supplier<List<String>> supplier = () -> new ArrayList<>(map.values());
        List<String> strings = supplier.get();
        Consumer<String> consumer = (string) -> System.out.println(string);
        Function<String, String> function = (s -> s.toUpperCase());
        for (String string : strings) {
            consumer.accept(function.apply(string));
        }
    }
}