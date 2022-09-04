package org.example;

import java.util.Scanner;

/**
 * @author oleg on 03.09.2022
 */
public class Ex1 {

  public static void main(String[] args) {
    System.out.println("Напишите метод, который получает следующие параметры: координаты " +
        "центра круга, радиус круга и координаты некой точки. Метод должен проверить, " +
        "находится ли данная точка внутри круга. ");
    Scanner scanner = new Scanner(System.in);
    System.out.println("Circle center X: ");
    int circleX = scanner.nextInt();
    System.out.println("Circle center Y: ");
    int circleY = scanner.nextInt();
    System.out.println("Circle radius: ");
    int radius = scanner.nextInt();
    System.out.println("Dot X: ");
    int dotX = scanner.nextInt();
    System.out.println("Dot Y: ");
    int dotY = scanner.nextInt();

    String result = isDotInsideCircle(circleX, circleY, radius, dotX, dotY) ? "Точка внутри круга" : "Точка снаружи круга";
    result(result);
  }
  private static boolean isDotInsideCircle(int circleX, int circleY, int radius, int dotX, int dotY) {
    return (Math.abs(dotX) <= circleX + radius) && (Math.abs(dotY) <= circleY + radius);
  }

  private static void result(String result) {
    System.out.println(result);
  }
}
