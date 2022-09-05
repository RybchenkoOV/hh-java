package org.example;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

/**
 * @author oleg on 05.09.2022
 */

public class Ex2FunctionalInterfaceTask {
  public static void main(String[] args) {
    System.out.println("Написать функциональный интерфейс с методом, который принимает число и возвращает булево значение. " +
        "Написать реализацию такого интерфейса в виде лямбда-выражения, которое возвращает true если переданное число делится" +
        "без остатка на 13.");

    Scanner scanner = new Scanner(System.in);
    System.out.println("Введите значение: ");
    int input = scanner.nextInt();
    MyFunctionalPredicator myFunPred = x -> (x % 13) == 0;
    System.out.println("Результат деления без остатка на 13: " + myFunPred.checkTheValue(input));
  }
}
// Реализуем функциональный интефейс здесь же
@FunctionalInterface
interface MyFunctionalPredicator {
  boolean checkTheValue(Integer value);
}
