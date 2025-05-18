package ru.job4j.sandbox;

import java.util.Arrays;
import java.util.Comparator;

public class SandBox {
    public static  int[] array = {25, 3, 4, 2, 1, -1, 6, -999, 9, 11, 14, 12, 10};

    Comparator<String> comparatorText = (left, right) -> left.compareTo(right);
    Comparator<String> comparatorDescSize = (left, right) -> Integer.compare(right.length(), left.length());

    public static int[] bubble(int[] arr) {
        for (int j = 0; j < arr.length - j; j++) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
        return arr;
    }

    public static  void arrayPrint(int[] arrayToPrint) {
        for (int item : arrayToPrint) {
            System.out.print(item + ",");
        }
    }

    /** Пример рекурсии,  писал сам, нигде смотрел не читал */
    public static void rec(int i) {
        String[] array = {"1", "3", "5", "7", "9", "11", "13", "15", "17", "19"};
        String[] array2 = {"1", "3", "5", "7", "9", "11", "13", "15", "17", "19"};
        if (i < array.length) {
            System.out.println(array[i]);
            i++;
            rec(i);
        }
    }

public static void main(String[] args) {
    System.out.println("было:");
    arrayPrint(array);
    System.out.println();
    arrayPrint(bubble(array));
    /* вызов рекурсии */
    rec(0);
    }
}



