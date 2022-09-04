package org.example;

/**
 * @author oleg on 04.09.2022
 */
abstract class Vehicle {
private String type;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public abstract void setVehicleMark(String mark);
}