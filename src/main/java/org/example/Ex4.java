package org.example;

import java.util.stream.IntStream;

/**
 * @author oleg on 03.09.2022
 */
public class Ex4 {
  public static void main(String[] args) {
    System.out.println("Напишите программу, которая формирует два массива " +
        "(не обязательно одинакового размера) целых чисел. Программа возвращает " +
        "массив значений, которые присутствуют в первом массиве, но не присутствуют " +
        "во втором.\n" +
        "*Программа возвращает двумерный массив значений. " +
        "В первом кортеже массив значений, которые присутствуют в первом массиве, " +
        "но не присутствуют во втором. Во втором кортеже массив значений, которые " +
        "присутствуют во втором массиве, но не присутствуют в первом. ");

    int[] array1, array2;
    array1 = new int[20];
    array2 = new int[10];
    System.out.println("Array 1: ");
    for (int i = 0; i < array1.length; i++) {
      array1[i] = ((int) (Math.random() * 50) - 1);
      System.out.print(array1[i] + " ");
    }
    System.out.println();
    System.out.println("Array 2: ");
    for (int i = 0; i < array2.length; i++) {
      array2[i] = ((int) (Math.random() * 50) - 1);
      System.out.print(array2[i] + " ");
    }
    System.out.println();
    System.out.println("Result: ");
    for (int i = 0; i < array1.length; i++) {
      int finalI = i;
      if (IntStream.of(array2).noneMatch(x -> x == array1[finalI])){
        System.out.print(array1[i] + " ");
      }
    }
  }
}
