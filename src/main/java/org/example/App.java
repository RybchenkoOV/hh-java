package org.example;

import java.sql.SQLException;

/**
 * @author oleg on 04.10.2022
 */
public class App {
  public static void main(String[] args) throws SQLException {
    MyTable table = new MyTable();
    table.createTabe();
    table.fillData();
  }
}
