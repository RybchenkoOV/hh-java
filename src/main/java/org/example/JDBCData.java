package org.example;

/**
 * @author oleg on 04.10.2022
 */
public class JDBCData {
  private final String DB_DRIVER = "org.postgresql.Driver";
  private final String DB_NAME = "test_db";
  private final String DB_URL = "jdbc:postgresql://localhost/test_db";
  private final String USER = "admin";
  private final String PASSWORD = "admin";

  public String getSSL() {
    return SSL;
  }

  private final String SSL = "true";


  public String getDB_DRIVER() {
    return DB_DRIVER;
  }

  public String getDB_NAME() {
    return DB_NAME;
  }

  public String getDB_URL() {
    return DB_URL;
  }

  public String getUSER() {
    return USER;
  }

  public String getPASSWORD() {
    return PASSWORD;
  }

}
