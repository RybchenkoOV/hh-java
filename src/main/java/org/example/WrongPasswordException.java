package org.example;

/**
 * @author oleg on 12.09.2022
 */
public class WrongPasswordException extends Exception{
  private String message;

  public WrongPasswordException(String message) {
    super(message);
  }

  public WrongPasswordException() {
    System.out.println("Это дефолтное исключение");
  }
}
