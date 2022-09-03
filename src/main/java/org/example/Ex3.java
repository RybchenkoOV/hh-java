package org.example;

import java.util.Scanner;

/**
 * @author oleg on 03.09.2022
 */
public class Ex3 {

  // Тут сделаю специально с минимальными затратами памяти на типы данных

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("В инструкции по пользованию лифтом в торговом центре написано: " +
        "«Не более 6 человек или не более 450 кг». Перед входом в лифт установлен прибор, " +
        "который подсчитывает входящих в лифт и определяет вес до входа в лифт. " +
        "Прибор автоматически прекращает доступ к лифту, если вход очередного человека может " +
        "нарушить инструкцию. Напишите программу, которая принимает с клавиатуры значения, " +
        "каждое из которых - вес очередного человека, входящего в лифт. Ввод данных " +
        "продолжается до тех пор, пока соблюдается требование, указанное в инструкции. " +
        "Программа должна выводить на экран следующую итоговую информацию: \n" +
        "• количество людей, вошедших в лифт; \n" +
        "• общий их вес; \n" +
        "• причина, по которой прекращен вход людей в лифт.\n");

    byte totalPeopleCount = 0;
    short totalWeight = 0;
    while (isTooMuchPeople(totalPeopleCount) && isTooMuchWeight(totalWeight)) {
      System.out.println("Input weight: ");
      short inputWeight = Short.parseShort(scanner.nextLine());
      totalPeopleCount++;
      totalWeight = (short) (totalWeight + inputWeight);
      System.out.println("People " + totalPeopleCount + " Weight " + totalWeight);
      isTooMuchPeople(totalPeopleCount);
      isTooMuchWeight(totalWeight);
    }
  }

  private static boolean isTooMuchPeople(byte peopleCount) {
    if (peopleCount > 6) {
      System.out.println("Too much people!!!");
      return false;
    }
    return true;
  }

  private static boolean isTooMuchWeight(short inputWeight) {
    if (inputWeight > 450) {
      System.out.println("Too heavy!!!");
      return false;
    }
    return true;
  }
}
