package org.example;

/**
 * @author oleg on 12.09.2022
 */
public class WrongLoginException extends Exception{
private String message;

  public WrongLoginException(String message) {
    super(message);
  }

  public WrongLoginException() {
    System.out.println("Это дефолтное исключение");
  }
}
