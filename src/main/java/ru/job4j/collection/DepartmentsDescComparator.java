package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
       String rootLeft = left.split("/", 2)[0];
       String rootRight = right.split("/", 2)[0];
       int result = rootRight.compareTo(rootLeft);
       if (result == 0) {
           result = left.compareTo(right);
       }
        return result;
    }
}