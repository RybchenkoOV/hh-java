package org.example;

import java.util.Scanner;

/**
 * @author oleg on 05.09.2022
 */

public class Ex3AnotherFunctionalInterfaceTask {
  public static void main(String[] args) {
    System.out.println("писать функциональный интерфейс с методом, который принимает три дробных числа: a, b, c и " +
        "возвращает тоже дробное число. Написать реализацию такого интерфейса в виде лямбда-выражения, которое возвращает " +
        "дискриминант. Кто забыл, D = b^2 — 4ac.");

    Scanner scanner = new Scanner(System.in);
    System.out.println("Введите a: ");
    double setA = scanner.nextInt();
    System.out.println("Введите b: ");
    double setB = scanner.nextInt();
    System.out.println("Введите c: ");
    double setC = scanner.nextInt();

    CalcDInterface calcDInterface = (double a, double b, double c) -> {
      double d = (Math.pow(b, 2) - 4 * a * c);
      return d;
    };
    System.out.println("Результат D: " + calcDInterface.countD(setA, setB, setC));
  }
}

// Реализуем функциональный интефейс здесь же
@FunctionalInterface
interface CalcDInterface {
  double countD(double a, double b, double c);
}


