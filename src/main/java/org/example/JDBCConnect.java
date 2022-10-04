package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Hello world!
 */
public class JDBCConnect {
  JDBCData jdbcData = new JDBCData();
  Properties props = new Properties();
  public Connection connectToDB() throws SQLException {
    props.setProperty("user", jdbcData.getUSER());
    props.setProperty("password", jdbcData.getPASSWORD());
    props.setProperty("ssl", jdbcData.getSSL());
    return DriverManager.getConnection(jdbcData.getDB_URL(), props);
  }
}