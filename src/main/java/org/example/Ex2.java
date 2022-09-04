package org.example;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 * @author oleg on 04.09.2022
 */
public class Ex2 {
  public static void main(String[] args) {
    System.out.println("Дано натуральное число N. Напишите метод выводящий все цифры " +
        "по одной, в обычном порядке, разделяя их пробелами или новыми строками. " +
        "При решении этой задачи нельзя использовать строки, списки, массивы, циклы. " +
        "Разрешена только рекурсия и целочисленная арифметика.");
    Scanner scanner = new Scanner(System.in);
    System.out.println("Введите натуральное число: ");
    Long inputNumber = scanner.nextLong();

    System.out.println(printDigits(inputNumber));
  }

  private static String printDigits(Long number) { // Не знаю, насколько честно получится так, все-таки стринга, но по условию задачи нам надо разделять значения
    if (number < 10) return String.valueOf(number);
    return printDigits(number / 10) + " | " + number % 10; // логика, если меньше 10 то выводим число, если нет, то убираем десятки и возвращаем результат от деления на 10
  }

  // Пробовал кастомно звпилить через NumberFormat, чтобы проставлять проблелы после каждой цифры. Простого решения нет, т.к. неизвестен размер числа. Кажется исследование этого будет оверхедом.
}

