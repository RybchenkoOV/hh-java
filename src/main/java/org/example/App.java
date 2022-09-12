package org.example;

import java.util.Objects;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws WrongLoginException, WrongPasswordException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ввдите логин: ");
        String inputLogin = scanner.nextLine();
        System.out.println("Ввдите пароль: ");
        String inputPassword = scanner.nextLine();
        System.out.println("Повторите пароль: ");
        String inputRepeatPassword = scanner.nextLine();

        System.out.println("Результат выполнения: " + authorize(inputLogin, inputPassword, inputRepeatPassword));

    }

    private static boolean authorize(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        String regEx = "[a-zA-Z0-9_]{1,20}";

        try {
            if (login.matches(regEx)) {
                System.out.println("Логин соответствует политике ввода!");
            } else throw new WrongLoginException("Введен недопустимый символ");
            if (password.matches(regEx)) {
                System.out.println("Пароль соответствует политике ввода!");
            } else throw new WrongPasswordException();
            if (Objects.equals(confirmPassword, password)) {
                System.out.println("Пароли совпали!");
            } else System.out.println("Пароли не совпадают!");
        } catch (WrongLoginException e) {
            e.printStackTrace();
        } catch (WrongPasswordException e) {
            e.printStackTrace();
        }

        return (login.matches(regEx) && password.matches(regEx) && Objects.equals(confirmPassword, password));
    }
}
