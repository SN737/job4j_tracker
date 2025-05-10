package ru.job4j.sandbox;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SandBox {
    public static  int[] array = {25, 3, 4, 2, 1, -1, 6, -999, 9, 11, 14, 12, 10};

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

public static void main(String[] args) {

    System.out.println("было:");
    arrayPrint(array);
    System.out.println();
    arrayPrint(bubble(array));
    }
}



