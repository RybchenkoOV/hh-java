package org.example;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author oleg on 04.10.2022
 */
public class MyTable {
  JDBCConnect jdbcConnect = new JDBCConnect();

  public Statement createStatement() throws SQLException {
    return jdbcConnect.connectToDB().createStatement();
  }

  public void createTabe() throws SQLException {
    String sqlScript =
        "CREATE TABLE MY_TABLE " +
            "\"(id INTEGER not NULL, \" +\n" +
            "\" firstName VARCHAR(255), \" + \n" +
            "\" lastName VARCHAR(255), \" + \n" +
            "\" age INTEGER, \" + \n" +
            "\" PRIMARY KEY ( id ))\"";

    createStatement().executeUpdate(sqlScript);
  }

  public void fillData() {
    String sqlScript = "INSERT INTO MY_TABLE VALUES (%s, 'testFirstName', 'testLastName', 18)";
  }
}
