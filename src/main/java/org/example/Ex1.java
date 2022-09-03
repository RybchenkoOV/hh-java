package org.example;

import java.util.Scanner;

/**
 * @author Oleg Rybchenko on 03.09.2022
 */

public class Ex1 {

  public static void main(String[] args) {
    short number;
    Scanner scanner = new Scanner(System.in);

    System.out.println("Напишите программу, которая принимает с клавиатуры целое трехзначное положительное число и изменяет его следующим образом:\n" +
        "• для чисел, больших 500, - переставляет местами числа единиц и сотен (вместо 672 - 276); \n" +
        "• в остальных числах переставляются местами числа десятков и единиц (вместо 363 - 336). \n" +
        "Программа должна вывести на экран новое значение переменной.\n");

    while (true) {
      System.out.println("Введите число в диапазоне 0-999: ");
      number = scanner.nextShort();
      if (number >= 100 && number < 1000) {
        logic(number);
        break;
      } else {
        System.out.println("Неправильный ввод! Попробуйте еще раз");
      }
    }
  }

  private static void logic(Short number) {
    if (number >= 500) {
      System.out.println("Результат (меняем сотни с единицами) " + swapPosition(number, false));
    } else if (number >= 0) {
      System.out.println("Результат (меняем десятки с единицами) " + swapPosition(number, true));
    }
  }

  private static String swapPosition(short number, boolean isLessThan500) {
//        String parseStr = number + ""; // Это как перевести любой Number в String без явного парсинга
    String parseStr = Short.toString(number);
    String result;
    String c1 = String.valueOf(parseStr.charAt(0));
    String c2 = String.valueOf(parseStr.charAt(1));
    String c3 = String.valueOf(parseStr.charAt(2));

    if (!isLessThan500) {
      result = c3 + c2 + c1;
      return (result); // Возвращаем именно стрингу, иначе при перестановке 600 будем получать ведущий ноль
    }
    result = c2 + c1 + c3; // Тут в ДЗ ошибка, написано поменять десятки и единицы, но пример числа неверный. Нужно не 363-336, а 363-633
    return (result);
  }
}
