
package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("canuck8@gmail.com",  "Connor Garland");
        map.put("canuck6@gmail.com",  "Brock Boeser");
        map.put("canuck17@gmail.com",  "Philipp Hronek");
        for (String key : map.keySet()) {
            System.out.println(key);
        }
    }
}