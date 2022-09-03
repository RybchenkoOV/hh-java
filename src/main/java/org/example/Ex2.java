package org.example;

import java.util.ArrayList;

/**
 * @author Oleg Rybchenko on 03.09.2022
 */

public class Ex2 {
  private static ArrayList<Integer> baseArray;
  private static ArrayList<Integer> arrayEndsWithZero;


  public static void main(String[] args) {
    System.out.println("\n" +
        "Напишите программу, которая выводит на экран все трехзначные числа, для которых соблюдаются два условия: \n" +
        "• само число заканчивается на 0; \n" +
        "• сумма нечетных делителей этого числа тоже заканчивается на 0. \n");

    // Создаем массив значений (в задании 1 использовал short, чтобы показать работу с короткими типами данных здесь
    // буду для удобства использовать int)
    System.out.println("Base array " + createBaseArray());

    // Создаем массив элементов из baseArray, которые оканчиваются на 0
    System.out.println("Array ends with zeros " + endsWithZero());

    // Проверяем массив arrayEndsWithZero на условие, что сумма нечетных делителей оканчивается на 0
    System.out.println("Result: ");
    for (int j = 0; j < arrayEndsWithZero.size(); j++) {
      int sum = 0;
      for (int k = 1; k <= arrayEndsWithZero.get(j); k++) {
        if (arrayEndsWithZero.get(j) % k == 0) {
          if (k % 2 != 0) {
            sum = sum + k;
          }
        }
      }
      if (String.valueOf(sum).endsWith("0")) {
        System.out.println(sum);
      }
    }
  }

  private static ArrayList<Integer> createBaseArray() {
    baseArray = new ArrayList<>();
    for (int i = 100; i < 1000; i++) {
      baseArray.add(i);
    }
    return baseArray;
  }

  private static ArrayList<Integer> endsWithZero() {
    arrayEndsWithZero = new ArrayList<>();
    for (int i = 0; i < baseArray.size(); i++) {
      String element = String.valueOf(baseArray.get(i));
      if (element.endsWith("0")) {
        arrayEndsWithZero.add(Integer.valueOf(element));
      }
    }
    return arrayEndsWithZero;
  }
}
